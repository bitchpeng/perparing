package com.bitchpeng.sharding.geo;

import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GeoTest {
    @Autowired
    private RedissonClient redissonClient;
    public void test(){
        RGeo<Object> test_geo = redissonClient.getGeo("test_geo");
        test_geo.add(new GeoEntry(121.34111, 31.14146, "家"));
        test_geo.add(new GeoEntry(121.33881, 31.13970, "明珠苑"));
        test_geo.add(new GeoEntry(121.33682, 31.13658, "九亭文化广场"));


        Map<Object, GeoPosition> map = test_geo.pos("家");
        Double dist = test_geo.dist("家", "明珠苑", GeoUnit.METERS);
        Double dist2 = test_geo.dist("家", "九亭文化广场", GeoUnit.METERS);
        //指定半径圆 key:member value:距离
        Map<Object, Double> objectDoubleMap = test_geo.radiusWithDistance("家", 1000, GeoUnit.METERS);
        //半径圆中 key:member value:经纬度对象
        Map<Object, GeoPosition> objectGeoPositionMap = test_geo.radiusWithPosition("家", 1000, GeoUnit.METERS);

        //将半径内的数据存入另一个geo并排序
        long l = test_geo.radiusStoreSortedTo("test_geo2", "家", 1000, GeoUnit.METERS);
        //将半径内的数据存入另一个geo
        long store = test_geo.radiusStoreTo("test_geo3", "家", 1000, GeoUnit.METERS);
        return;
    }
}
