package com.todorex.offer17;

/**
 * 打印从1到最大的n位数
 *
 * @Author rex
 * 2018/7/22
 */
public class Solution2 {
    /**
     * 把问题转成数字排列的解法
     * 相当于回溯法
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigitsRecursively(number, n, 0);

    }

    /**
     * 递归核心
     * @param number
     * @param length
     * @param index 字符串的第几位
     */
    public void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index > length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i +'0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }
    /**
     * 根据字符串打印出数字
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
}
