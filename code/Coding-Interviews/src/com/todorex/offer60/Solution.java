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
public class Solution {
    /**
     * 骰子最大值
     */
    int maxValue = 6;

    /**
     * 递归解法
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> result = new ArrayList<AbstractMap.Entry<Integer, Double>>();
        if (n <= 0) {
            return result;
        }
        // 结果次数
        int[] resultArray = new int[maxValue * n - n + 1];
        // 可能情况
        int total = (int)Math.pow(maxValue, n);
        // 算出次数
        probability(n, resultArray);
        for (int i = 0; i < resultArray.length; i++) {
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i + n, (double)resultArray[i] / total));
        }
        return result;
    }

    /**
     * 递归开始
     * @param n
     * @param resultArray
     */
    public void probability(int n, int[] resultArray) {
        for (int i = 1; i <= maxValue; i++) {
            probability(n, i, n, resultArray);
        }
    }

    /**
     * 递归核心
     * @param original
     * @param sum
     * @param current
     * @param resultArray
     */
    public void probability(int original, int sum, int current, int[] resultArray) {
        if (current == 1) {
            resultArray[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original, sum + i, current - 1, resultArray);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        List<Map.Entry<Integer, Double>> result = solution.dicesSum(n);
        int a = 1;

    }
}
