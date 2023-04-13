package com.bitchpeng.design.pattern.factory.factory_method.factory.impl;

import com.bitchpeng.design.pattern.factory.factory_method.factory.FreeGoodsFactory;
import com.bitchpeng.design.pattern.factory.simple_factory.service.IFreeGoods;
import com.bitchpeng.design.pattern.factory.simple_factory.service.impl.DiscountFreeGoods;

/**
 * 生产优惠券发放接口-具体工厂
 * @author spikeCong
 * @date 2022/9/9
 **/
public class DiscountFreeGoodsFactory implements FreeGoodsFactory {

    @Override
    public IFreeGoods getInstance() {
        //返回的是具体产品
        return new DiscountFreeGoods();
    }
}
