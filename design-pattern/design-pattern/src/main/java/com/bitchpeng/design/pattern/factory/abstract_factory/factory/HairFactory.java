package com.bitchpeng.design.pattern.factory.abstract_factory.factory;

import com.bitchpeng.design.pattern.factory.abstract_factory.product.AbstractFreezer;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.AbstractTV;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.HairFreezer;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.HairTV;

/**
 * 具体工厂
 * @author spikeCong
 * @date 2022/9/15
 **/
public class HairFactory implements AppliancesFactory {

    @Override
    public AbstractTV createTV() {
        return new HairTV();
    }

    @Override
    public AbstractFreezer createFreezer() {
        return new HairFreezer();
    }
}
