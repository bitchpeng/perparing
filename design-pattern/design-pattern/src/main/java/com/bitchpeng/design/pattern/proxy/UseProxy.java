package com.bitchpeng.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UseProxy implements InvocationHandler {
    private ProxyInterface proxyInterface;

    public UseProxy(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("经纪人商量合同");
        method.invoke(proxyInterface, args);
        System.out.println("经纪人收钱");
        return null;

    }
}
