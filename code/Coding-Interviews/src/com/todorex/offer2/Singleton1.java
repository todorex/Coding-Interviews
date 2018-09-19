package com.todorex.offer2;

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
