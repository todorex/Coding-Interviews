# 题目描述
设计一个类，我们只能生成该类的一个实例。
# 题目考点
* 考察应聘者对单例模式的理解
* 考察应聘者对基础语法（Java）的理解
* 考察应聘者对多线程编程的理解

# 解题思路
使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。

私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。

# 自己解题
```java
/**
 * 实现Singleton模式
 * @Author rex
 * 2018/6/7.
 */
public class Singleton {

    /**
     * 私有静态变量
     */
    private static Singleton singleton;

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:39
     * @Description 私有构造函数
     */
    private Singleton() {
    }

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:41
     * @Description 公有获取单例对象静态函数
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
```

考虑欠缺点：
* 缺少对多线程编程的理解(属于懒汉式线程不安全单例模式)

# 正确解题
## 饿汉式（线程安全）
```Java
/**
 * 饿汉式单例模式
 * 线程安全
 * @Author rex
 * 2018/6/8
 */
public class Singleton1 {
    /**
     * 私有静态变量
     * 直接实例化
     * 丢失了延迟实例化带来的节约资源的优势
     */
    private static Singleton1 singleton = new Singleton1();

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:39
     * @Description 私有构造函数
     */
    private Singleton1() {
    }

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:41
     * @Description 公有获取单例对象静态函数
     */
    public static Singleton1 getSingleton() {
        return singleton;
    }

}
```
## 懒汉式（线程安全）
```Java
/**
 * 懒汉式单例模式
 * 线程安全
 *
 * @Author rex
 * 2018/6/7
 */
public class Singleton2 {
    /**
     * 私有静态变量
     */
    private static Singleton2 singleton;

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:39
     * @Description 私有构造函数
     */
    private Singleton2() {

    }

    /**
     * @Author rex
     * @Date 2018/6/8 下午7:28
     * @Description 公有获取单例对象静态函数
     * 在方法级别上加锁
     * 当一个线程进入该方法之后，其它线程试图进入该方法都必须等待，
     * 因此性能上有一定的损耗
     */
    public static synchronized Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
```
## 懒汉式双重校验锁（线程安全）最佳
```Java
/**
 * 实现懒汉式双重校验锁Singleton模式
 * 线程安全
 *
 * @Author rex
 * 2018/6/7
 */
public class Singleton3 {
    /**
     * 私有静态变量
     */
    private static Singleton3 singleton;

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:39
     * @Description 私有构造函数
     */
    private Singleton3() {
    }

    /**
     * @Author rex
     * @Date 2018/6/7 下午9:46
     * @Description 公有获取单例对象静态函数
     * 加同步锁前后两次判断实例是否已存在
     * 缩小的同步代码块
     */
    public static Singleton3 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
```
