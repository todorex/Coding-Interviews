package com.todorex.offer20;

/**
 * 表示数值的字符串
 * @Author rex
 * 2018/7/24
 */
public class Solution1 {
    /**
     * 定义str的变量的位置
     */
    private int i = 0;

    /**
     * 非正则表达式解法
     *
     * 利用模式分析为A[.[B]][e|EC]或者.B[e|EC]
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        // 防止特殊输入
        if (str == null || str.length < 0) {
            return false;
        }
        // 1. 扫描A

        boolean numberic = scanInteger(str);
        // 2. 扫描B
        if (i < str.length && str[i] == '.') {
            i++;
            // 小数后面可以没有数字
            numberic = scanUnSignedInteger(str) || numberic;
        }
        // 3. 扫描C
        if (i < str.length && (str[i] == 'e' || str[i] == 'E')) {
            i++;
            // 出现e/E 后面必须跟数字
            numberic = scanInteger(str) && numberic;
        }

        return numberic && i == str.length;
    }

    /**
     * 扫描整数部分（有可能在起始处有‘+’或者‘-’）
     * @param str
     * @return
     */
    private boolean scanInteger(char[] str) {
        if (i < str.length && (str[i] == '+' || str[i] == '-')) {
            i++;
        }
        return scanUnSignedInteger(str);
    }

    /**
     * 扫描无符号整数部分（在起始处不可能有‘+’或者‘-’）
     * @param str
     * @return
     */
    private boolean scanUnSignedInteger(char[] str) {
        // 用于对比是否符合
        int temp = i;
        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            i++;
        }
        return i > temp;
    }
}
