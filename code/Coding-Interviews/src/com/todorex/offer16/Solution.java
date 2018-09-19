package com.todorex.offer16;

/**
 * 数值的整数次方
 *
 * @Author rex
 * 2018/7/21
 */
public class Solution {
    /**
     * 自己解题
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}
