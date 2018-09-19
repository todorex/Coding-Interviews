package com.todorex.offer48;

import java.util.*;

/**
 * 最长不含重复字符的子字符串
 *
 * @Author rex
 * 2018/8/31
 */
public class Solution {

    /**
     * 动态规划解题
     * @param s
     * @return
     */
    public int longestSubsingWithoutDuplication(String s) {
        // 关键（动态规划的体现）
        int curLength = 0;

        int maxLength = 0;

        // 存放下标
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 数组下标
            Integer index = indexMap.get(s.charAt(i));
            // 如果第i个字符之前没有出现过 或者 出现的下标不在当前不包含重复字符的子字符串内
            if (index == null || (i - index) > curLength) {
                curLength++;
            } else {
                // 如果第i个字符出现的下标在当前不包含重复字符的子字符串内
                // 与之前最长的字符串比较
                maxLength = Math.max(maxLength, curLength);
                // 调整为两个重复字符串的距离
                curLength = i - index;
            }
            indexMap.put(s.charAt(i),i);
        }
        maxLength = Math.max(maxLength, curLength);

        return maxLength;
    }

}
