package org.apache.rocketmq.example.transaction.custom;


import org.apache.rocketmq.example.transaction.custom.db.MyException;

import java.util.function.Supplier;

public class DefaultLocalTransactionExecutor <R> implements LocalTransactionExecutor<R> {
    private MyException myException;
    private Exception exception;
    private R result;
    private Runnable runnable;
    private Supplier<R> supplier;

    public DefaultLocalTransactionExecutor(Runnable runnable) {
        this.runnable = runnable;
    }

    public DefaultLocalTransactionExecutor(Supplier<R> supplier) {
        this.supplier = supplier;
    }

    @Override
    public final void execute() {
        try {
            if (null != runnable) {
                runnable.run();
            } else {
                result = supplier.get();
            }
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Override
    public final R getResult() throws Exception {
        if (null != myException) {
            throw myException;
        }
        if (null != exception) {
            throw exception;
        }
        return result;
    }
}
