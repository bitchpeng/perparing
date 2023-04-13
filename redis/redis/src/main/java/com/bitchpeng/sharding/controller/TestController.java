package com.bitchpeng.sharding.controller;

import com.bitchpeng.sharding.geo.GeoTest;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.api.SortOrder;
import org.redisson.client.protocol.ScoredEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GeoTest geoTest;

    @GetMapping("/test")
    public String test() {
//        geoTest.test();
        redisTemplate.opsForValue().set("string","test");
        Object string = redisTemplate.opsForValue().get("string");


        BoundHashOperations boundHashOps = redisTemplate.boundHashOps("boundHashOps");
        boundHashOps.put("test","test");
        boundHashOps.get("test");

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.removeRange("zSetOperations",0,zSetOperations.zCard("zSetOperations"));
        zSetOperations.add("zSetOperations","1",1.2D);
        zSetOperations.add("zSetOperations","2",1.1D);
        zSetOperations.add("zSetOperations","3",0.1D);
        zSetOperations.add("zSetOperations","4",0.3D);
        //总数
        zSetOperations.zCard("zSetOperations");
        //获取分数
        Long zSetOperations3 = zSetOperations.rank("zSetOperations", "4");
        Long aLong = zSetOperations.removeRange(zSetOperations, 1, 2);

        Set<String> zSetOperations1 = zSetOperations.range("zSetOperations", 1, 2);
//        Set<String> zSetOperations2 = zSetOperations.rangeByScore("zSetOperations", 1D, 2D);

        ListOperations<String, String> stringStringListOperations = redisTemplate.opsForList();
        stringStringListOperations.leftPush("ddd","ddd");
//        stringStringListOperations.range("ddd",)


//        RScoredSortedSet<String> scoredSortedSet = redissonClient.getScoredSortedSet("ScoredSortedSet");
//        scoredSortedSet.delete();
//        scoredSortedSet.add(0.5D,"23123");
//        scoredSortedSet.add(0.4D,"324");
//        scoredSortedSet.add(0.8D,"43");
//        scoredSortedSet.add(0.1D,"56");
//        scoredSortedSet.add(1.5D,"5");
//        Integer rank = scoredSortedSet.rank("5");
//        Double score = scoredSortedSet.getScore("5");
//        Collection<String> strings = scoredSortedSet.readAll();
//        Collection<ScoredEntry<String>> scoredEntries = scoredSortedSet.entryRange(0, 2);
        log.info("----------------------");
//        log.info(rank.toString());
//        log.info(rank.toString());



        return "";

    }


}
