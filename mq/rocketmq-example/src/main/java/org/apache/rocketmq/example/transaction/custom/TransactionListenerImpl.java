/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.example.transaction.custom;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.example.transaction.custom.db.LocalTransactionRecordService;

@Slf4j
public class TransactionListenerImpl implements TransactionListener {

    private LocalTransactionRecordService localTransactionRecordService;
    @Override
//   TODO @Transactional
    //这里加事务的作用在于我们需要保证
    // localTransactionRecordService.insert(txId)和((DefaultLocalTransactionExecutor) arg).execute()这两行逻辑在一个事务里
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        //我们需要在这里操作们的业务并且提交事务，然后返回相应的状态来通知RocketMQ推送or丢弃发送的消息
        if (arg instanceof DefaultLocalTransactionExecutor) {
            //我们可以利用RocketMQ的transactionId来记录本次的事务，
            //也可以自己定义事务ID，通过ThreadLocal传过来
            String txId = msg.getTransactionId();
            try {
                localTransactionRecordService.insert(txId);
                //处理业务
                ((DefaultLocalTransactionExecutor) arg).execute();
            }catch (Exception e) {
                log.error("executeLocalTransaction failed msg：", e);
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
            return LocalTransactionState.COMMIT_MESSAGE;

        }
        return LocalTransactionState.ROLLBACK_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        //RocketMQ通过这里来回查上面的事务的状态，默认1min回查一次，一共回查15次，
        //一般而言，这个方法是不会被回调的，因为上面的方法里我们已经返回了状态
        String txId = msg.getTransactionId();
        boolean exist = localTransactionRecordService.exist(txId);
        //这里查不到的时候返回UNKNOW在于，有可能事务还没有提交，回查就开始了
        return exist ? LocalTransactionState.COMMIT_MESSAGE : LocalTransactionState.UNKNOW;
    }


}
