package com.bitchpeng.sharding.pipline;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class PiplineTest {

    @Autowired
    private RedissonClient redissonClient;

    public void test2() {
        BatchOptions options = BatchOptions.defaults()
// 指定执行模式
//
// ExecutionMode.REDIS_READ_ATOMIC - 所有命令缓存在Redis节点中，以原子性事务的方式执行。
//
// ExecutionMode.REDIS_WRITE_ATOMIC - 所有命令缓存在Redis节点中，以原子性事务的方式执行。
//
// ExecutionMode.IN_MEMORY - 所有命令缓存在Redisson本机内存中统一发送，但逐一执行（非事务）。默认模式。
//
// ExecutionMode.IN_MEMORY_ATOMIC - 所有命令缓存在Redisson本机内存中统一发送，并以原子性事务的方式执行。
//
                .executionMode(BatchOptions.ExecutionMode.IN_MEMORY)

// 告知Redis不用返回结果（可以减少网络用量）
                .skipResult()

// 将写入操作同步到从节点
// 同步到2个从节点，等待时间为1秒钟
                .syncSlaves(2, 1, TimeUnit.SECONDS)

// 处理结果超时为2秒钟
                .responseTimeout(2, TimeUnit.SECONDS)

// 命令重试等待间隔时间为2秒钟
                .retryInterval(2, TimeUnit.SECONDS)

// 命令重试次数。仅适用于未发送成功的命令
                .retryAttempts(4);
    }


    public void test() throws ExecutionException, InterruptedException {

        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();

        RBatch batch = redisson.createBatch(BatchOptions.defaults());
        batch.getMap("test1").fastPutAsync("1", "2");
        batch.getMap("test2").fastPutAsync("2", "3");
        batch.getMap("test3").putAsync("2", "5");
        RFuture<Long> future = batch.getAtomicLong("counter").incrementAndGetAsync();
        batch.getAtomicLong("counter").incrementAndGetAsync();

        // result could be acquired through RFuture object returned by batched method
        // or
        // through result list by corresponding index
        future.whenComplete((res, exception) -> {
            // ...
        });

        BatchResult<?> res = batch.execute();
        Long counter = (Long) res.getResponses().get(3);

        future.get().equals(counter);

        redisson.shutdown();


    }


}
