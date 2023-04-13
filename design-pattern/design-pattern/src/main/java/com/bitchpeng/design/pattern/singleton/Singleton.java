package com.bitchpeng.design.pattern.singleton;

import com.bitchpeng.design.pattern.singleton.demo02.Singleton_02;
import com.bitchpeng.design.pattern.singleton.demo03.Singleton_03;
import com.bitchpeng.design.pattern.singleton.demo06.Singleton_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式
 */
public class Singleton {


    public static void main(String[] args) throws Exception {

//        extracted1();
        Singleton_06.INSTANCE.setData("12312321");
        System.out.println(Singleton_06.INSTANCE.getData());
        Singleton_06.INSTANCE.setData("22222222");
        System.out.println(Singleton_06.INSTANCE.getData());
    }

    private static void extracted1() {
        for (int i = 0; i < 100; i++) {
            Runnable r = () -> {
                try {
                    extracted();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            };
            r.run();
        }
    }


    private static void extracted() throws Exception {
        Class<Singleton_03> clazz = Singleton_03.class;
        Constructor<Singleton_03> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton_03 singleton_03 = declaredConstructor.newInstance();
        System.out.println(singleton_03);
//        System.out.println(Singleton_03.getInstance());
    }

}
