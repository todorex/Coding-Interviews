package com.todorex.offer38;

/**
 * 字符串的排列
 *
 * @Author rex
 * 2018/8/14
 */
public class Solution {
    /**
     * 字符串排序
     *
     * @param str
     */
    void permutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] ca = str.toCharArray();
        permutation(ca, 0);
    }

    /**
     * 字符数组排序
     * 递归方法
     *
     * @param ca
     * @param begin
     */
    void permutation(char[] ca, int begin) {
        if (begin == ca.length) {
            System.out.println(String.valueOf(ca));
        } else {
            for (int i = begin; i < ca.length; i++) {
                // 和后面一个字符交换位置
                swap(ca, i, begin);
                permutation(ca, begin + 1);
                // 换回来
                swap(ca, i, begin);
            }
        }

    }

    /**
     * 交换位置
     * @param ca
     * @param i
     * @param j
     */
    void swap(char[] ca, int i, int j) {
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }

}
