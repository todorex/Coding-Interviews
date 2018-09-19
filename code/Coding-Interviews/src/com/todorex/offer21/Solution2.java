package com.todorex.offer21;

import com.todorex.offer6.Solution3;

/**
 * @Author rex
 * 2018/7/25
 */
public class Solution2 {
    /**
     * 判断的策略
     */
    private ReorderStrategy reorderStrategy;

    public Solution2() {
    }

    public Solution2(ReorderStrategy reorderStrategy) {
        this.reorderStrategy = reorderStrategy;
    }

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
            while (i < j && !reorderStrategy.reorderBySomething(array, i)) {
                i++;
            }
            // 第二个指针，直到遇见奇数，然后开始准备交换
            while (i < j && reorderStrategy.reorderBySomething(array, j)) {
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

    public static void main(String[] args) {
        int[] array = new int[] {2,4,4,6,8,10,1,3,5};
        ReorderStrategy reorderStrategy = new OddEventReorderStategy();
        Solution2 solution = new Solution2(reorderStrategy);
        solution.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
