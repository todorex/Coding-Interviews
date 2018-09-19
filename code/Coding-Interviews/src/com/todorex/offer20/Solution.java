package com.todorex.offer20;

/**
 * 表示数值的字符串
 *
 * @Author rex
 * 2018/7/24
 */
public class Solution {
    /**
     * 全靠debug暴力出来
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        boolean haveE = false;
        boolean havaDot = false;
        boolean isNumber = false;
        int length = str.length;
        int i;
        for (i = 0; i < length; ) {
            if (i == length - 1) {
                if ((str[i] >= '0' && str[i] <= '9')) {
                    i++;
                } else {
                    return isNumber;
                }
            } else if (i == 0) {
                if (str[i] == '+' || str[i] == '-' || (str[i] >= '0' && str[i] <= '9')) {
                    i++;
                } else {
                    return isNumber;
                }
            } else if ((str[i] >= '0' && str[i] <= '9')) {
                i++;
            } else if (str[i] == 'e' || str[i] == 'E') {
                haveE = true;
                if (i + 1 < length && (str[i + 1] == '-' || str[i + 1] == '+' || (str[i + 1] >= '0' && str[i + 1] <= '9'))) {
                    i += 2;
                } else {
                    return isNumber;
                }

            } else if (!haveE && !havaDot && !haveE && str[i] == '.') {
                i++;
                havaDot = true;
            } else {
                return isNumber;
            }

        }
        if (i == length) {
            isNumber = true;

        }
        return isNumber;
    }
}
