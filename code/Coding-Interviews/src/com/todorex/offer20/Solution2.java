package com.todorex.offer20;

/**
 * 表示数值的字符串
 *
 * @Author rex
 * 2018/7/24
 */
public class Solution2 {
    /**
     * 正则表达式解法
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        // 防止特殊输入
        if (str == null || str.length < 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
