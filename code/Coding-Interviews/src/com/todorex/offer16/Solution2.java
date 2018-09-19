package com.todorex.offer16;

import java.math.BigDecimal;

/**
 * 数值的整数次方
 *
 * @Author rex
 * 2018/7/21
 */
public class Solution2 {

    private boolean g_invalid_input = false;

    /**
     * 全面但不够高效的解法
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        // 0的0次方没有意义
        if (doubleCompare(base, 0.0) == 0 && exponent == 0) {
            g_invalid_input = false;
            return 0.0;
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithPositiveExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0/result;
        }
        return result;
    }



    /**
     * 指数为正时，得到的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double powerWithPositiveExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithPositiveExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    /**
     * 比较两个浮点型大小
     * @param a
     * @param b
     * @return
     */
    public int doubleCompare(double a, double b) {
        BigDecimal data1 = new BigDecimal(a);
        BigDecimal data2 = new BigDecimal(b);
        return data1.compareTo(data2);
    }
}
