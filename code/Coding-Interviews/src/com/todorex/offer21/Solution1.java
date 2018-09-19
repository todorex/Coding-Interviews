package com.todorex.offer21;


/**
 * 调整数组顺序使奇数位于偶数前面
 * @Author rex
 * 2018/7/24
 */
public class Solution1 {
    /**
     * 只完成基本功能的解法
     * @param array
     */
    public void reOrderArray(int [] array) {
        // 防止特殊输入
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            // 第一个指针，直到遇见偶数，然后开始准备交换
            while (i < j && (array[i] & 1) != 0) {
                i++;
            }
            // 第二个指针，直到遇见奇数，然后开始准备交换
            while (i < j && (array[j] & 1) == 0) {
                j--;
            }
            // 开始交换
            if (i < j) {
                swapArray(array, i, j);
            }
        }
    }

    /**
     * 交换数组的两个值
     * @param array
     * @param i
     * @param j
     */
    public void swapArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}