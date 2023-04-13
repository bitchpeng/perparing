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
@TableName("users")
@Data
@ToString
@Accessors(chain = true)
public class User {

    @TableId
    private Long id;

    private String username;

    private String phone;

    private String password;

}
