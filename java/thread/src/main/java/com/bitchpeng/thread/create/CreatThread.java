package com.bitchpeng.thread.create;

import java.util.concurrent.*;

public class CreatThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new A().start();
//        new Thread(new B(),"B").start();
        //Callable
        FutureTask<String> target = new FutureTask<>(new C());
        new Thread(target).start();;
        target.get();
        //CPU密集 核心 n   最大n+1
        //io密集  核心 2n  最大2n+
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
//                2, Runtime.getRuntime().availableProcessors()+1,10, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(10)
//        );




    }

    static class A extends Thread {
        @Override
        public void run() {

            System.out.println("线程A");
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {

            System.out.println("线程B");
        }
    }

    static class C implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("线程C");
            Thread.sleep(10000000);
            System.out.println("睡眠结束");
            return "线程C";
        }
    }


}
