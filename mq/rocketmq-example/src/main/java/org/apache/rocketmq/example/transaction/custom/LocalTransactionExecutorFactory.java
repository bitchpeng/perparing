package org.apache.rocketmq.example.transaction.custom;

import java.util.function.Supplier;

public class LocalTransactionExecutorFactory {

    //无返回的执行器
    public static LocalTransactionExecutor<Void> run(Runnable runnable) {
        return new DefaultLocalTransactionExecutor<>(runnable);
    }

    //有返回的执行器
    public static <R> LocalTransactionExecutor<R> get(Supplier<R> supplier) {
        return new DefaultLocalTransactionExecutor<>(supplier);
    }
}
