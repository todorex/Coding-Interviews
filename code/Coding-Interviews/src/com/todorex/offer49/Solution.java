package com.todorex.offer49;

/**
 * 丑数
 *
 * @Author rex
 * 2018/9/1
 */
public class Solution {
    /**
     * 求出第index个丑数
     * @param index
     * @return
     */
    public int getUglyNumber_Solution(int index) {
        // 防止特殊输入
        if (index <= 0) {
            return 0;
        }

        int count = 0;
        int base = 0;
        while (count != index) {
            base++;
            if (isUglyNumber(base)) {
                count++;
            }
        }
        return base;

    }

    /**
     * 判断是否为丑数
     * @param number
     * @return
     */
    boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }


}
