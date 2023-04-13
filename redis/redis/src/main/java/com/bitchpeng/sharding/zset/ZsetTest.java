package com.bitchpeng.sharding.zset;

import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZsetTest {



    @Autowired
    private RedissonClient redissonClient;



    public void test(){

        RSortedSet<Object> sortedSet = redissonClient.getSortedSet("getSortedSet");

        RScoredSortedSet<Object> getSortedSet = redissonClient.getScoredSortedSet("getSortedSet");

//        getSortedSet.rank()



    }


}
