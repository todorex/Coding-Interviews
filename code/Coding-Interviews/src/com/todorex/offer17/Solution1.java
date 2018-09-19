package com.todorex.offer17;

/**
 * 打印从1到最大的n位数
 *
 * @Author rex
 * 2018/7/22
 */
public class Solution1 {
    /**
     * 在字符串上模拟数字加法的解法
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        // 防止非法输入
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        initCharArray(number);
        while (!increment(number)) {
            printNumber(number);
        }
    }


    /**
     * 字符串表示的数字上模拟加法
     * @param number
     * @return
     */
    private boolean increment(char[] number) {
        // 是否超出999....
        boolean isOverflow = false;
        // 进位数
        int takeOver = 0;
        for (int i = number.length-1; i >= 0; i--) {
            int sum = number[i] - '0' + takeOver;
            if (i == number.length-1) {
                sum++;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 根据字符串打印出数字
     * 这个我一会也想出来
     * @param number
     */
    private void printNumber(char[] number) {
        // 默认字符串不以0开始
        boolean isBegining0 = true;

        for (int i = 0; i < number.length; i++) {
            if (isBegining0 && number[i] != '0') {
                isBegining0 = false;
            }
            if (!isBegining0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /**
     * 初始化字符数组
     *
     * 使其每个字符初始为'0'
     * @param chars
     */
    public void initCharArray(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }
    }

}
