package com.bitchpeng.sharding;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Bloomfilter {


    @Autowired
    private RedissonClient redissonClient;


    public void test() {
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloomFilter");
        //初始化布隆过滤器 期望误差率为0.03
        bloomFilter.tryInit(500000000, 0.03);
        //存在 true  不粗在 false
        bloomFilter.add("wqeqw");
        bloomFilter.add("11111");
        if (bloomFilter.contains("11111")) {
            //存在的 设置为true
            //读取处理


        } else {
            //不存在返回空

        }
    }
}
