package com.bitchpeng.design.pattern.factory.simple_factory.service;

import com.bitchpeng.design.pattern.factory.simple_factory.entity.AwardInfo;
import com.bitchpeng.design.pattern.factory.simple_factory.entity.ResponseResult;

/**
 * 免费商品发放接口
 * @author spikeCong
 * @date 2022/9/8
 **/
public interface IFreeGoods {

    ResponseResult sendFreeGoods(AwardInfo awardInfo);

}
