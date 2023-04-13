package com.bitchpeng.sharding.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bitchpeng.sharding.entity.Course;
import com.bitchpeng.sharding.entity.Shop;
import com.bitchpeng.sharding.mapper.CourseMapper;
import com.bitchpeng.sharding.mapper.IShopMapper;
import com.bitchpeng.sharding.mapper.PayOrderMapper;
import com.bitchpeng.sharding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private IShopMapper shopMapper;

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;



    @GetMapping("/getShops")
    public List<Shop> getShops() {
        List<Shop> shopEntities = shopMapper.selectList(Wrappers.<Shop>lambdaQuery());
        return shopEntities;

    }





    @GetMapping("/test")
    public List<Shop> test() {


//        payOrderMapper.insert(new PayOrder().setOrder_id(123L).setCount(2).setProduct_name("产品1").setUser_id(123123L));


        courseMapper.insert(new Course().setBrief("sadqw").setCid(86764565767L).setCname("cname").setPrice(768789D).setStatus(1).setUserId(465767L));
        courseMapper.insert(new Course().setBrief("sadzxc").setCid(86764565768L).setCname("cname").setPrice(768789D).setStatus(1).setUserId(465768L));




        return null;

    }
    @GetMapping("/test1")
    public List<Course> test1() {

        List<Course> courses = courseMapper.selectList(Wrappers.lambdaQuery());


        return courses;

    }




}
