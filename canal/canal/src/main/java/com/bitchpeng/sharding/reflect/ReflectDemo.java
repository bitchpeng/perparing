package com.bitchpeng.sharding.reflect;

import lombok.Data;

@Data
public class ReflectDemo {


    public ReflectDemo() {
    }

    public ReflectDemo(String name) {
        this.name = name;
    }

    private String name;




}
