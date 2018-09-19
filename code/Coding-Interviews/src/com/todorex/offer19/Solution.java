package com.todorex.offer19;

/**
 * 正则表达式匹配
 *
 * @Author rex
 * 2018/7/23
 */
public class Solution {
    /**
     * 正则表达式匹配
     * （递归）
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);

    }

    /**
     * 正则表达式匹配分步
     *
     * @param str     字符串
     * @param pattern 模式
     * @param i       str的下标
     * @param j       patter的下标
     * @return
     */
    public boolean matchCore(char[] str, char[] pattern, int i, int j) {
        // 终止条件
        if (i == str.length && j == pattern.length) {
            return true;
        }
        // 当模式不足以配置字符串时
        if (i < str.length && j == pattern.length) {
            return false;
        }
        // 当模式中的第二个字符是“*”时：
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            // 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式
            if (i != str.length && pattern[j] == str[i] || (pattern[j] == '.' && i != str.length)) {
                return
                        // 字符串后移1字符，模式后移2字符
                        matchCore(str, pattern, i + 1, j + 2)
                                // 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位
                                || matchCore(str, pattern, i + 1, j)
                                // 模式后移2字符，相当于x*被忽略
                                || matchCore(str, pattern, i, j + 2);
            } else {
                return matchCore(str, pattern, i, j + 2);
            }

        }
        // 如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的
        if ((i != str.length && str[i] == pattern[j]) || (pattern[j] == '.' && i != str.length)) {
            return matchCore(str, pattern, i + 1, j + 1);
        }
        // 如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false
        return false;
    }

}
