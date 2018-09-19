package com.todorex.offer21;

/**
 * 按照奇偶重排序
 * @Author rex
 * 2018/7/25
 */
public class OddEventReorderStategy implements ReorderStrategy {
    /**
     * 返回是否为偶数
     * @param array
     * @param index
     * @return
     */
    @Override
    public boolean reorderBySomething(int[] array, int index) {
        return (array[index] & 1) == 0;
    }
}
