package com.todorex.offer21;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @Author rex
 * 2018/7/24
 */
public class Solution {
    /**
     * 调整数组顺序
     * @param array
     */
    public void reOrderArray(int [] array) {
        // 防止特殊输入
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0;
        int j = array.length-1;
        while (j - i != 1) {
            if ((array[i] & 1) == 0) {
                // 为偶数
                swapArray(array, i, j);
                j--;
            } else {
                i++;
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
        Solution solution = new Solution();
        solution.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
