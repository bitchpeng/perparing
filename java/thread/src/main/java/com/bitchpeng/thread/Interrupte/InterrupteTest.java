package com.bitchpeng.thread.Interrupte;

import lombok.Data;
import lombok.SneakyThrows;

//线程中断
public class InterrupteTest {


    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(new A());
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupt();

//        B target = new B();
//        Thread thread = new Thread(target);
//        thread.start();
//        Thread.sleep(3000);
//        target.setFlag(false);

        Thread thread = new Thread(new C());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();

    }


    static class A extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("线程A");
            }

        }
    }

    @Data
    static class B extends Thread {
        boolean flag = true;

        @SneakyThrows
        @Override
        public void run() {
            while (flag) {
                System.out.println("线程A");
            }

        }
    }

    static class C extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(10000);
            System.out.println("线程A");


        }
    }


}
