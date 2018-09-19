package com.todorex.offer57;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的两个数字
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution {
    /**
     * 直观的O(N2)的解法
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

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;
    }
}
