package com.bitchpeng.design.pattern.customcode.miniprogram;

import com.bitchpeng.design.pattern.customcode.miniprogram.factory.AbstractPlatformFactory;
import com.bitchpeng.design.pattern.customcode.miniprogram.factory.AlipayPlatformFactory;
import com.bitchpeng.design.pattern.customcode.miniprogram.factory.DouyinPlatformFactory;
import com.bitchpeng.design.pattern.customcode.miniprogram.factory.WeixinPlatformFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MiniProgramFactoryEnum {

    WEI_XIN(new WeixinPlatformFactory()), ALIPAY(new AlipayPlatformFactory()), DOU_YIN(new DouyinPlatformFactory());

    private AbstractPlatformFactory abstractPlatformFactory;


}
