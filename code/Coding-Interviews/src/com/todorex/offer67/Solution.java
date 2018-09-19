package com.todorex.offer67;

/**
 * 把字符串转换成整数
 *
 * @Author rex
 * 2018/9/19
 */
public class Solution {
    /**
     * 把字符串转换成整数
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        // 表示10进制转换
        int radix = 10;

        // 防止特殊输入
        if (str == null) {
            throw new NumberFormatException("null");
        }
        // 定义返回值
        int result = 0;
        // 正负数标志位
        boolean negative = false;

        int i = 0, len = str.length();

        if (len > 0) {
            // 处理首字符为+、-号的情况
            // 取出第一个字符判断是否为+、-
            char firstChar = str.charAt(0);
            // + 、 - 的ASCII码都比0小
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                } else if (firstChar != '+') {
                    throw new NumberFormatException("invalid first char");
                }
                if (len == 1) {
                    throw new NumberFormatException("invalid string");
                }
                i++;
            }

            while (i < len) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    result = result * radix + str.charAt(i) - '0';
                    // 处理数字溢出
                    if ((!negative && result > Integer.MAX_VALUE) || (negative && result < Integer.MIN_VALUE)) {
                        throw new NumberFormatException("invalid string");
                    }
                    // 处理非法字符
                } else {
                    throw new NumberFormatException("invalid char");
                }
                i++;
            }
            // 处理空串
        } else {
            throw new NumberFormatException("invalid string");
        }
        return negative ? -result : result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("+123s"));
    }
}
