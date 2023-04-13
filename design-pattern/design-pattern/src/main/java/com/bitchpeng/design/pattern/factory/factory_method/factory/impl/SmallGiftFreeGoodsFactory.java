package com.bitchpeng.design.pattern.factory.factory_method.factory.impl;

import com.bitchpeng.design.pattern.factory.factory_method.factory.FreeGoodsFactory;
import com.bitchpeng.design.pattern.factory.simple_factory.service.IFreeGoods;
import com.bitchpeng.design.pattern.factory.simple_factory.service.impl.SmallGiftFreeGoods;

/**
 * 生产小礼品发放接口-具体工厂
 * @author spikeCong
 * @date 2022/9/9
 **/
public class SmallGiftFreeGoodsFactory implements FreeGoodsFactory {

    @Override
    public IFreeGoods getInstance() {
        return new SmallGiftFreeGoods();
    }
}
