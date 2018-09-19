package com.todorex.offer57;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution2 {
    /**
     * 双指针解法
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // 非法输入
        if (sum <= 0) {
            return result;
        }
        // 定义连续正数序列的首尾指针，都是递增的
        int small = 1;
        int big = 2;
        int cur = small + big;
        while (small <= sum/2 && small < big) {
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                big++;
                cur +=big;
            } else if (cur > sum) {
                cur -= small;
                small++;
            } else {
                big++;
                cur += big;
            }

        }
        return result;
    }
}
