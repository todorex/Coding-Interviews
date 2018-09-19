package com.todorex.offer64;

/**
 * 求1+2+...+n
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {

    public int sum_Solution(int n) {
        int sum = n;
        boolean temp = n > 0 && (sum += sum_Solution(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum_Solution(5));
    }

}
