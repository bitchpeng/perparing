@[TOC](ArrayList源码解读)

# ArrayList源码解读

## 继承关系

![继承关系](https://img-blog.csdnimg.cn/37a0fab691ed4e3fb56eaaedf24fe747.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAcXFfMzYwMjcxNDY=,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
ArrayList实现了List, RandomAccess, Cloneable, java.io.Serializable等接口。
ArrayList实现了List，提供了基础的添加、删除、遍历等操作。
ArrayList实现了RandomAccess，提供了随机访问的能力。
ArrayList实现了Cloneable，可以被克隆。
ArrayList实现了Serializable，可以被序列化。

## RandomAccess接口
作用：该接口是空接口，用于标识，在Collections中的==binarySearch==方法里面会用到，实现了该接口走的是for循环（方便顺序读取），未实现该接口走的是迭代器遍历（方便链式读取）

## 源码解析
### 属性
```java
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空数组，如果传入的容量为0时使用
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 空数组，传传入容量时使用，添加第一个元素的时候会重新初始为默认容量大小
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存储元素的数组
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * 集合中元素的个数
     */
    private int size;
```

- **DEFAULT_CAPACITY**
  默认容量为10，也就是通过new ArrayList()创建时的默认容量。
- **EMPTY_ELEMENTDATA**
  空的数组，这种是通过new ArrayList(0)创建时用的是这个空数组。
- **DEFAULTCAPACITY_EMPTY_ELEMENTDATA**
  也是空数组，这种是通过new ArrayList()创建时用的是这个空数组，与EMPTY_ELEMENTDATA的区别是在添加第一个元素时使用这个空数组的会初始化为DEFAULT_CAPACITY（10）个元素。
- **elementData**
  真正存放元素的地方，使用transient是为了不序列化这个字段。
  至于没有使用private修饰，后面注释是写的“为了简化嵌套类的访问”，但是楼主实测加了private嵌套类一样可以访问。
  private表示是类私有的属性，只要是在这个类内部都可以访问，嵌套类或者内部类也是在类的内部，所以也可以访问类的私有成员。
- **size**
  真正存储元素的个数，==而不是elementData数组的长度==。

### 方法

- 构造
    1. ArrayList(int initialCapacity)构造方法
    2. ArrayList()构造方法
    3. ArrayList(Collection<? extends E> c)构造方法
- 成员方法
    1. add(E e)方法
    2. add(int index, E element)方法
    3. addAll(Collection<? extends E> c)方法
    4. get(int index)方法
    5. remove(int index)方法
    6. remove(Object o)方法
    7. retainAll(Collection<?> c)方法
    8. removeAll(Collection<?> c)

## 总结
（1）ArrayList内部使用数组存储元素，当数组长度不够时进行扩容，每次加一半的空间，ArrayList不会进行缩容；
（2）ArrayList支持随机访问，通过索引访问元素极快，时间复杂度为O(1)；
（3）ArrayList添加元素到尾部极快，平均时间复杂度为O(1)；
（4）ArrayList添加元素到中间比较慢，因为要搬移元素，平均时间复杂度为O(n)；
（5）ArrayList从尾部删除元素极快，时间复杂度为O(1)；
（6）ArrayList从中间删除元素比较慢，因为要搬移元素，平均时间复杂度为O(n)；
（7）ArrayList支持求并集，调用addAll(Collection<? extends E> c)方法即可；
（8）ArrayList支持求交集，调用retainAll(Collection<? extends E> c)方法即可；
（7）ArrayList支持求单向差集，调用removeAll(Collection<? extends E> c)方法即可；# 功能快捷键


## 面试题
1. elementData设置成了transient，那ArrayList是怎么把元素序列化的呢？
2. 为什么线程不安全
3. java版本的改动
4. 扩容机制
5. RandomAccess接口