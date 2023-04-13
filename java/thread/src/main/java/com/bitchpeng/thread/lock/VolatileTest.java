package com.bitchpeng.thread.lock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileTest {


    public static volatile boolean flag = false;

    public static volatile A a=new A();

    @Data
    public static class A {
        private boolean flag = false;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (!a.flag) {

            }
            log.info("已更改回值");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.flag = true;
            log.info("已更改");
        }).start();

    }


}
