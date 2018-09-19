package com.todorex.offer51;

/**
 * 数组中的逆序对
 *
 * @Author rex
 * 2018/9/3
 */
public class Solution {
    /**
     * low
     * 时间复杂度太大
     * @param array
     * @return
     */
    public int inversePairs(int [] array) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{7, 5, 6, 4};
        System.out.println(solution.inversePairs(array));
    }
}
