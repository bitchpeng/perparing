package com.bitchpeng.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

@Slf4j
public class ScheduleTest {

    public static void main(String[] args) {
        log.info("准备执行任务");
        Queue<String> queue=new ConcurrentLinkedDeque<>();

        List<String> taskList= Arrays.asList("1号","2号","5号","7号");
        queue.addAll(taskList);

        ScheduledExecutorService pool= Executors.newScheduledThreadPool(1);
        for(int i=0;i<queue.size();i++) {
            ScheduledFuture<String> future = pool.schedule(new Callable<String>() {
                @Override
                public String call() throws InterruptedException {
                    log.info(Thread.currentThread().getName() + " "+System.currentTimeMillis()+"当前执行的任务是" + queue.poll());
                    TimeUnit.SECONDS.sleep(2);
                    return "callSchedule";
                }
            }, 5, TimeUnit.SECONDS);
        }
    }
}
