package com.todorex.offer15;

/**
 * 二进制中1的个数
 * @Author rex
 * 2018/7/20
 */
public class Solution {
    /**
     * 惊喜解法
     *
     * 利用了把一个整数减去1之后再后原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变成0
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n-1) & n;
        }
        return  count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOf1(-1));;
    }

}
