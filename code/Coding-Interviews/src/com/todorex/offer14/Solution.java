package com.todorex.offer14;

/**
 * 剪绳子
 * 动态规划解法
 * @Author rex
 * 2018/7/20
 */
class Solution {
    /**
     * 动态规划剪绳子
     * @param n 绳子长度
     * @return
     */
    public int cutRopeByDP(int n) {
        //异常处理
        if(n < 0) {
            throw new IllegalArgumentException("Illegal Paramters");
        }
        // 得到绳子长度为1-3的显然的最优解
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }

        //创建数组存储子问题最优解
        int[] result = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            result[i] = i;
        }
        // 开始求解每一个绳子长度的最优解
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp = result[j] * result[i - j];
                if (temp > max) {
                    max = temp;
                }
            }
            result[i] = max;
        }
        return result[n];
    }
}