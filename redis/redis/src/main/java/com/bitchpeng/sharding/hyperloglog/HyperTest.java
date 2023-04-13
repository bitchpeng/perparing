package com.bitchpeng.sharding.hyperloglog;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RHyperLogLog;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HyperTest {
    //①. UV:Unique Visitor,独立访客,一般理解为客户端IP(需要去重考虑)
    //
    //②. PV:Page View,页面浏览量(不用去重)
    //
    //③. DAU:日活跃用户量(登录或者使用了某个产品的用户数(去重复登录的用户))
    //
    //④. MAU:MonthIy Active User,月活跃用户量
    @Autowired
    private RedissonClient redissonClient;


    public void test() {
        //pv pageview
        //uv uniqueview
        //dau 日活  每天0点清空 同步数据到数据库
        //mau 月活  每月最后一天24点清空 保存数据 或者根据日活表统计
//        redissonClient.getBinaryStream()
        RHyperLogLog<Object> test_hyperLogLog = redissonClient.getHyperLogLog("test_hyperLogLog");
        test_hyperLogLog.add("user1");
        test_hyperLogLog.add("user1");
        test_hyperLogLog.add("user1");
        long l = test_hyperLogLog.sizeInMemory();


        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloomFilter");
        //初始化布隆过滤器 期望误差率为0.03
        bloomFilter.tryInit(500000000, 0.03);
        //存在 true  不粗在 false


        bloomFilter.add("wqeqw");
        bloomFilter.add("11111");
        if (bloomFilter.contains("11111")) {
            //存在的 设置为true
            //读取处理


        } else {
            //不存在返回空

        }


    }

}
