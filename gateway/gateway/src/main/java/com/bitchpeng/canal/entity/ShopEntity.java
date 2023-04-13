package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bit_shop")
public class ShopEntity {

    private Long id;
    private String shopName;
    private int status;


}
