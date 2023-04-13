package com.bitchpeng.design.pattern.customcode.miniprogram.factory;

import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.IMiniProgram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.IOpenPlatform;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.WeixinMiniprogram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.WeixinOpenPlatform;

public class WeixinPlatformFactory implements AbstractPlatformFactory {

    @Override
    public IMiniProgram getMiniprogram() {
        return new WeixinMiniprogram();
    }
    @Override
    public IOpenPlatform getOpenPlatform() {
        return new WeixinOpenPlatform();
    }

}
