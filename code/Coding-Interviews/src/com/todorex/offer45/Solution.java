package com.todorex.offer45;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @Author rex
 * 2018/8/28
 */
public class Solution {

    /**
     * 新的排序规则解题
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        // 防止特殊输入
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        // 以防两个数相加溢出，将int 变成 string
        String[] numberStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = numbers[i] + "";
        }

        // 利用新的排序规则排序
        Arrays.sort(numberStrings, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder result = new StringBuilder();

        for (String s : numberStrings) {
           result.append(s);
        }

        return result.toString();
    }
}
