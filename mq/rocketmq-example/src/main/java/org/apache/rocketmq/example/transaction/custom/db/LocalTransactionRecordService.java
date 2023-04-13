package org.apache.rocketmq.example.transaction.custom.db;

public class LocalTransactionRecordService {


    public boolean insert(String msgID) {
        return true;
    }

    public boolean exist(String msgID) {
        return true;
    }


}
