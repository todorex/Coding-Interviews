package com.todorex.offer42;



/**
 * 连续子数组的最大和
 *
 * @Author rex
 * 2018/8/25
 */
public class Solution {
    /**
     * 找规律解法(思想还是动态规划的)
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];

        int curMax = max;
        for (int i = 1; i < array.length; i++) {

            if (curMax <= 0) {
                curMax = array[i];

            } else {
                curMax += array[i];

            }
            if (curMax > max) {
                max = curMax;
            }

        }
        return max;
    }
}
