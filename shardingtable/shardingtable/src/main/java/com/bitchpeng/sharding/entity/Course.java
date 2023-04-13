package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@TableName("t_course")
@Data
@ToString
@Accessors(chain = true)
public class Course implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long cid;
    private Long userId;
    private Long corderNo;
    private String cname;
    private String brief;
    private double price;
    private int status;
}
