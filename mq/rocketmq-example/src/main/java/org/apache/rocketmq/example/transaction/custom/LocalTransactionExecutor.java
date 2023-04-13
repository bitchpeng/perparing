package org.apache.rocketmq.example.transaction.custom;

public interface LocalTransactionExecutor<R> {


    /**
     * 执行本地业务并提交事务
     *
     * 
     */
    void execute();

    /**
     * 返回结果或抛异常
     *
     * 
     */
    R getResult() throws Exception;

}
