package com.todorex.offer50;

import java.util.Map;
import java.util.TreeMap;

/**
 * 第一个只出现一次的字符
 *
 * @Author rex
 * 2018/9/2
 */
public class Solution1 {
    /**
     * 利用数组构建的Map解题
     * @param str
     * @return
     */
    public char firstNotRepeatingChar(String str) {
        // 防止特殊输入
        if (str == null || str.length() == 0) {
            return '\0';
        }
        // 当字符都是数字和英文时，一个字符长度为8位，所以总共有256种可能
        final int TABLE_SIZE = 256;
        // 构建Map
        int[] hashTable = new int[TABLE_SIZE];
        for (int i = 0; i < str.length(); i++) {
            hashTable[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashTable[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.firstNotRepeatingChar("abaccdeff"));

    }
}
