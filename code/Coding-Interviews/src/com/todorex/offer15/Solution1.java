package com.todorex.offer15;

/**
 * 二进制中1的个数
 *
 * @Author rex
 * 2018/7/20
 */
public class Solution1 {
    /**
     * 常规解法
     * 利用1左移，然后与n进行位与操作
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        int index = 1;
        while (index != 0) {
            if ((n & index) > 0) {
                count ++;
            }
            index = index << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.numberOf1(-1));;
    }
}
