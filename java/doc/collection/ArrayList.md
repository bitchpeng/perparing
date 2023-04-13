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
  ==真正存储元素的个数，而不是elementData数组的长度==。

### 方法

- 构造
    1. ArrayList(int initialCapacity)构造方法
    2. ArrayList()构造方法
    3. ArrayList(Collection<? extends E> c)构造方法
- 成员方法
    1. add(E e)方法
    ```java
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // 确保内部容量---检测扩容
        elementData[size++] = e;           // 赋值
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

          //判断是否是空对象 是就将最小值设置为Max(DEFAULT_CAPACITY, minCapacity)
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    //扩容
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    //1.5倍扩容
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    ```
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
（7）ArrayList支持求单向差集，调用removeAll(Collection<? extends E> c)方法即可；  


## 面试题
1. elementData设置成了transient，那ArrayList是怎么把元素序列化的呢？
  
>  重写了writeObject与readObject方法,其目的是根据size来序列化对象长度没必要对没有赋值的空位置序列化<br>
>  ArrayList是会开辟多余空间来保存数据的，而系列化和反序列化这些没有存放数据的空间是要消耗更多资源的，所以ArrayList的数组就声明为transient，告诉虚拟机这个你别管，我自己来处理，然后就自己实现write/readObject方法，仅仅系列化已经存放的数据。

2. 扩容流程是怎样的，为什么线程不安全
   - ensureCapacityInternal 确认容量
     - 初始容量为空时判断传入的size+1跟初始容量对比  取最大值
       - size+1>elementData.length 开始grow扩容
         - newCapacity = oldCapacity + (oldCapacity >> 1) 获得1.5扩容后容量                 
           - newCapacity>MAX_ARRAY_SIZE 则尝试 hugeCapacity
             - elementData = Arrays.copyOf(elementData, newCapacity);
               - System.arraycopy()  --将源数组拷贝到目标数组                                ==native方法  线程不安全==
   - elementData[size++] = e; 赋值                                                        ==不安全==

3. java版本的改动
> 1.7的时候是初始化就创建一个容量为10的数组，1.8后是初始化先创建一个空数组，第一次add时才扩容为10
4. 扩容机制 为什么扩容因子是1.5
>  首先内存获取是要开销的，如果系统能重用之前的缓存，那就节省了很多开销
>  这里比较一下k=2与k=1.5的情况
>  - k=2 最后一次的扩容size要比之前扩容用到的内存的总和要多，需要向操作系统申请缓存以外的内存
>  - k=1.5  最后一次的扩容size要比之前扩容用到的内存的总和要少，不需要向操作系统申请缓存以外的内存
5. RandomAccess接口
> 该接口是空接口，用于标识，在Collections中的==binarySearch==方法里面会用到，实现了该接口走的是for循环（方便顺序读取），未实现该接口走的是迭代器遍历（方便链式读取）
6. ArrayList与LinkedList的区别？