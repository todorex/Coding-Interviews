package com.todorex.offer10;

/**
 * 最简单的递归
 * 没有考虑时间复杂度
 * @Author rex
 * 2018/7/15
 */
public class Solution {
    // 很垃圾
    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
