package com.todorex.offer63;

/**
 * 股票的最大利润
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * O(N)解题
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 防止特殊输入
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 保存最大利润
        int maxProfit = 0;
        // 保存之前的最小值
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
