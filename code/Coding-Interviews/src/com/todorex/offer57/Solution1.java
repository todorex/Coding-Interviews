package com.todorex.offer57;

import java.util.ArrayList;

/**
 * 和为s的两个数字
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution1 {
    /**
     * 双指针解法
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        // 非法输入
        if (array == null || array.length < 2) {
            return result;
        }
        // 定义首尾指针
        int smallIndex = 0;
        int bigIndex = array.length - 1;
        while (smallIndex < bigIndex) {
            int cur = array[smallIndex] + array[bigIndex];
            if (cur == sum) {
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                return result;
            } else if (cur > sum) {
                bigIndex--;
            } else {
                smallIndex++;
            }
        }
        return result;
    }
}
