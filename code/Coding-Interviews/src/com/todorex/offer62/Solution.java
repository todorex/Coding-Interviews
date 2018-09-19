package com.todorex.offer62;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * 环形链表解题
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_Solution(int n, int m) {
        // 防止特殊输入
        if (n < 0 || m < 1) {
            return -1;
        }
        // 构造链表
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                current++;
                if (current == list.size()) {
                    current = 0;
                }
            }
            // 删除之后，注意边界
            list.remove(current);
            if (current > list.size() - 1) {
                current = 0;
            }
        }
        return list.get(current);

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 400;
        int m = 977;
        int result = solution.lastRemaining_Solution(n, m);
        System.out.println(result);
    }
}
