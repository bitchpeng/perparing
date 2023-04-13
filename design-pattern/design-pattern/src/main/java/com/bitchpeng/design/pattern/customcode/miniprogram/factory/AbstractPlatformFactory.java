package com.bitchpeng.design.pattern.customcode.miniprogram.factory;

import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.IMiniProgram;
import com.bitchpeng.design.pattern.customcode.miniprogram.product.open.IOpenPlatform;

/**
 * 小程序抽象工厂
 */
public interface AbstractPlatformFactory {


    IMiniProgram getMiniprogram();

    IOpenPlatform getOpenPlatform();


}
