package com.bitchpeng.sharding.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        Class<?> aClass = Class.forName("com.bitchpeng.sharding.reflect.ReflectDemo");
        //无参构造
        Object o = aClass.newInstance();

        //有参构造
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("212");

        //获取对象数据


        ReflectDemo reflectDemo = new ReflectDemo("test");

        Field[] declaredFields = reflectDemo.getClass().getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {

            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);
            Object o2 = declaredField.get(reflectDemo);
            System.out.println(o2);


        }


    }

}
