package com.todorex.offer21;

/**
 * 重排序策略
 * @Author rex
 * 2018/7/25
 */
public interface ReorderStrategy {
    /**
     * 判断符合某种条件
     * @param array
     * @param index
     */
    boolean reorderBySomething(int[] array, int index);
}
