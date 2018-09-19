package com.todorex.offer2;

/**
 * 懒汉式双重校验锁单例模式
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
