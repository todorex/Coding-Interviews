package com.todorex.offer49;

/**
 * 丑数
 *
 * @Author rex
 * 2018/9/1
 */
public class Solution1 {
    /**
     * 求出第index个丑数
     * 空间换时间
     *
     * @param index
     * @return
     */
    public int getUglyNumber_Solution(int index) {
        // 防止特殊输入
        if (index <= 0) {
            return 0;
        }
        // 存放所有丑数
        int[] dp = new int[index];
        dp[0] = 1;
        int nextUglyIndex = 1;
        // 存储乘以2、3、5的下标（当一个数乘完，下标加1）
        int i2 = 0, i3 = 0, i5 = 0;

        while (nextUglyIndex < index) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] *5));
            dp[nextUglyIndex] = min;
            if (dp[i2] * 2 == min) {
                i2++;
            }
            if (dp[i3] * 3 == min) {
                i3++;
            }
            if (dp[i5] * 5 == min) {
                i5++;
            }
            nextUglyIndex++;
        }
        return dp[index - 1];

    }

}
