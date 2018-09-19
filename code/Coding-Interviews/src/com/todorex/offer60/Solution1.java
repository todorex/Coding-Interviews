package com.todorex.offer60;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * n个骰子的点数
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution1 {
    /**
     * 骰子最大值
     */
    int maxValue = 6;

    /**
     * 动态规划解题
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> result = new ArrayList<AbstractMap.Entry<Integer, Double>>();
        if (n <= 0) {
            return result;
        }

        // 这里一定要用long型，不能用int型，数大了之后会造成int型溢出
        // 还折腾了一会
        long[][] probabilities = new long[2][maxValue * n + 1];

        // 数组转换标志
        int flag = 0;

        // 用第一个骰子初始化数组
        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            // 清空不可能出现的位
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;

        }

        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxValue * n; i++) {
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i, probabilities[flag][i] / total));
        }
        return result;

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 15;
        List<Map.Entry<Integer, Double>> result = solution.dicesSum(n);
        int a = 1;

    }
}
