@[TOC](序列化)

# 序列化与反序列化

## 作用
作用于对象，
序列化: 将对象状态信息转化成可传输/可存储的形式的过程
反序列化: 将可传输/可存储的形式转化为对象的过程
主要应用于网络传输: 
1. RPC(远程过程调用协议) RMI(远程方法调用-PRC的实现只支持java)
2. 网络通信时进行传输对象
3. 落库

## transient 关键字
将对象属性局限于内存中不再会被序列化

## Exteranlizable接口（Serializable接口的子类）

Exteranlizable能够自定义序列化的属性

==writeExternal()==和==readExternal()==方法可以指定序列化哪些属性两个方法执行的顺序需要一样

Exteranlizable优先级比transient关键字高,当一个属性被transient修饰又被Exteranlizable处理那么以Exteranlizable处理结果为准

## 静态变量能被序列化吗
静态属于类本身  获取方式只能类名获取 与对象无关