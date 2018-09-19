package com.todorex.offer17;

/**
 * 打印从1到最大的n位数
 *
 * @Author rex
 * 2018/7/22
 */
public class Solution {
    /**
     * 已经掉入陷阱
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        int number = (int) Math.pow(10, n);
        for (int i = 1; i < number; i++) {
            System.out.println(i);
        }
    }
}
