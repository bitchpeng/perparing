package com.bitchpeng.thread.base;

public class InnerClass {

    {

    }

    public void test(){

         class C{
            //局部内部类
        }
        C c = new C();

    }
    public static void test2(){

        class C{
            //局部内部类
        }

    }

    class B {
        //实例内部类
    }

    static class C {
        //静态内部类
    }




}


class A {
    //外部类



}
