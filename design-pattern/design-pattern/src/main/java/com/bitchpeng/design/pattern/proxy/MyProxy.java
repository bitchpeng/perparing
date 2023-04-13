package com.bitchpeng.design.pattern.proxy;

import java.lang.reflect.Proxy;

public class MyProxy {


    public static void main(String[] args) {
        UseProxy useProxy=new UseProxy(new ProxyImpl());
        ProxyInterface o = (ProxyInterface)Proxy.newProxyInstance(ProxyImpl.class.getClassLoader(),
                ProxyImpl.class.getInterfaces(), useProxy);

        o.test();
        o.test2();

    }


}
