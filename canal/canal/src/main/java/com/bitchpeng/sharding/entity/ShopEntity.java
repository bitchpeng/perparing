package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@TableName("bit_shop")
public class ShopEntity {

    private Long id;
    private String shopName;
    private int status;


    public static void main(String[] args) {
        int [] x=new int[10];


    }

}
