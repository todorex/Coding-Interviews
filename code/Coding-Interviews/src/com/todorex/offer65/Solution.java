package com.todorex.offer65;

/**
 * 不用加减乘除做加法
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * 位运算解题
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2) {
        int sum, carry;
        do {
            // 1. 不考虑进位加
            sum = num1 ^ num2;
            // 2. 算出进位的值
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (carry != 0);
        // 3. 当没有进位的时候，num1就是最终的和
        return num1;
    }
}
