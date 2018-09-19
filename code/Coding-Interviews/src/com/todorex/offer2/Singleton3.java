package com.todorex.offer2;

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
                    return new Singleton3();
                }
            }
        }
        return singleton;
    }
}
