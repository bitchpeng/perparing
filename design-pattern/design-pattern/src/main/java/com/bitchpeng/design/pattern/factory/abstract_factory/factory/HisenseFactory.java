package com.bitchpeng.design.pattern.factory.abstract_factory.factory;

import com.bitchpeng.design.pattern.factory.abstract_factory.product.AbstractFreezer;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.AbstractTV;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.HisenseFreezer;
import com.bitchpeng.design.pattern.factory.abstract_factory.product.HisenseTV;

/**
 * @author spikeCong
 * @date 2022/9/15
 **/
public class HisenseFactory implements AppliancesFactory {

    @Override
    public AbstractTV createTV() {
        return new HisenseTV();
    }

    @Override
    public AbstractFreezer createFreezer() {
        return new HisenseFreezer();
    }
}
