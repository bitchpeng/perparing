package com.bitchpeng.design.pattern.customcode.miniprogram.factory;

import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.AlipayMiniprogram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.AlipayOpenPlatform;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.IMiniProgram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.IOpenPlatform;

public class AlipayPlatformFactory implements AbstractPlatformFactory {

    @Override
    public IMiniProgram getMiniprogram() {
        return new AlipayMiniprogram();
    }

    @Override
    public IOpenPlatform getOpenPlatform() {
        return new AlipayOpenPlatform();
    }
}
