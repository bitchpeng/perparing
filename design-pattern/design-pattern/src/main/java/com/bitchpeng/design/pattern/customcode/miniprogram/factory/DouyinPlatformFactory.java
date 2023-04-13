package com.bitchpeng.design.pattern.customcode.miniprogram.factory;

import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.DouyinMiniprogram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.DouyinOpenPlatform;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.IMiniProgram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.IOpenPlatform;

public class DouyinPlatformFactory implements AbstractPlatformFactory {



    @Override
    public IMiniProgram getMiniprogram() {
        return new DouyinMiniprogram();
    }


    @Override
    public IOpenPlatform getOpenPlatform() {
        return new DouyinOpenPlatform();
    }


}
