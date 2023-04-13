package com.bitchpeng.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class CourseSection {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long cid;  //课程id

    private Long userId;

    private String sectionName;

    private int status;
}
