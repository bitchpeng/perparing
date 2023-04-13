package com.bitchpeng.springdemo.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayListDemo {
    public static void main(String[] args) {
        arrayList();
    }

    public static void arrayList() {
        //this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        List<String> arrays=new ArrayList<>();
        log.info(arrays.size()+"");//0
        //initialCapacity>0    则使用elementData创建固定长度的数组
        //initialCapacity==0   elementData = EMPTY_ELEMENTDATA;
        //initialCapacity<0    报错
        List<String> arrays1=new ArrayList<>(12);
        log.info(arrays1.size()+"");//0
        //先替换elementData
        //长度为0则elementData = EMPTY_ELEMENTDATA;
        //长度大于0则类型不一样则直接拷贝Arrays.copyOf()
        List<String> arrays2=new ArrayList<>(arrays1);
        log.info(arrays2.size()+"");//0










        //避过泛型检查
        arrays1.add("dsafggsa");
        List<Integer> arrays3=new ArrayList(arrays1);
        //报错
//        Integer integer = arrays3.get(0);
//        log.info(arrays3.size()+"");//0

        List<Integer> arrays4=new ArrayList(3);
        arrays4.add(1);
        arrays4.add(2);
        arrays4.add(3);
        arrays4.add(4);





    }


}
