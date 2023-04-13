package com.bitchpeng.design.pattern.proxy;

public class ProxyImpl implements ProxyInterface {

    @Override
    public void test() {
        System.out.println("主方法");
    }

    @Override
    public void test2() {
        System.out.println("主方法2");

    }
}
