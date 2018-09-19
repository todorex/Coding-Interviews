package com.todorex.offer44;

/**
 * 数字序列中某一位的数字
 *
 * @Author rex
 * 2018/8/27
 */
public class Solution {
    /**
     * 求出数字序列中某一位的数字
     * @param index
     * @return
     */
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }
            index -= numbers * digits;
            digits++;
        }
    }

    /**
     * 当我们知道要找的哪一位数字位于某m位数之中后，使用下面的函数找出那位数字
     * @param index
     * @param digits
     */
    public int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        // 从左到右第m位，就是从右到左的第digits-m位
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 求出m位的数字的个数
     * @param digits 位数
     * @return
     */
    public int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10,digits - 1);
        return 9 * count;

    }

    /**
     * 求出m位的第一个数字
     * @param digits
     * @return
     */
    public int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return  (int) Math.pow(10, digits - 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输出7
        System.out.println(solution.digitAtIndex(1001));
    }

}
