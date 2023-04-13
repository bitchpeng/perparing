package com.bitchpeng.sharding.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bitchpeng.sharding.entity.ShopEntity;
import com.bitchpeng.sharding.mapper.IShopMapper;
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

    @GetMapping("/getShops")
    public List<ShopEntity> getShops() {
        List<ShopEntity> shopEntities = shopMapper.selectList(Wrappers.<ShopEntity>lambdaQuery());
        return shopEntities;

    }

}
