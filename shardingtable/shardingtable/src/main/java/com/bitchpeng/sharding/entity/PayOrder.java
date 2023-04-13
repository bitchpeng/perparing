package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author spikeCong
 * @date 2022/11/8
 **/
@TableName("pay_order") //逻辑表名
@Data
@ToString
@Accessors(chain = true)
public class PayOrder {

    @TableId
    private Long order_id;

    private Long user_id;

    private String product_name;

    private Integer count;


}
