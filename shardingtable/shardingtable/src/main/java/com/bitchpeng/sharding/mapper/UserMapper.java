package com.bitchpeng.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.bitchpeng.sharding.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author spikeCong
 * @date 2022/11/8
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
