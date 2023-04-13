package com.bitchpeng.design.pattern.customcode.miniprogram;

import com.bitchpeng.design.pattern.customcode.miniprogram.product.mini.IMiniProgram;

public class Comsumer {


    public static void main(String[] args) {
        IMiniProgram alipayMini = MiniProgramFactoryEnum.ALIPAY.getAbstractPlatformFactory().getMiniprogram();
        String accessToken = alipayMini.getAccessToken();

    }


}
