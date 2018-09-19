package com.todorex.offer2;

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
     * @Description 公有获取单例对象函数
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
