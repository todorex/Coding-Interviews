package com.todorex.offer10;

/**
 * 聪明的循环
 * 考虑时间复杂度
 * @Author rex
 * 2018/7/15
 */
public class Solution1 {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;
        int fib = 0;
        for (int i = 2; i <=n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }

}
