package com.bitchpeng.springdemo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Date;

@Slf4j
public class SerializableDemo {


    public static void main(String[] args)throws Exception {
        //序列化对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./objectFile.obj"));
        User customer = new User("王麻子", 24);
        out.writeObject("你好!");    //写入字面值常量
        out.writeObject(new Date());    //写入匿名Date对象
        out.writeObject(customer);    //写入customer对象
        out.close();


        //反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./objectFile.obj"));
        log.info("obj1 " + (String) in.readObject());    //读取字面值常量
        log.info("obj2 " + (Date) in.readObject());    //读取匿名Date对象
        User obj3 = (User) in.readObject();    //读取customer对象
        log.info("obj3 " + obj3);
        in.close();

    }


    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    public static class User implements Externalizable {
        //静态属于类本生  获取方式只能类名获取 与对象无关
        private static transient String AAA;
        private transient String name;
        private Integer age;

        public User() {
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject("名称");
            out.writeObject(222);
            out.writeObject("Aewrew");
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
           name= (String) in.readObject();
           age= (Integer) in.readObject();
           AAA= (String) in.readObject();
        }
    }
}
