package com.todorex.offer14;

/**
 * 剪绳子
 * 贪婪算法解法
 * @Author rex
 * 2018/7/20
 */
public class Solution1 {
    /**
     * 贪婪算法剪绳子
     * @param n 绳子长度
     * @return
     */
    public int cutRopeByGA(int n) {
        //异常处理
        if(n < 0) {
            throw new IllegalArgumentException("Illegal Paramters");
        }
        // 得到绳子长度为1-3的显然的最优解
        if(n < 2) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }

        int timesOfThree = n/3;


        if (n%3 == 1) {
            timesOfThree--;
        }
        int timesOfTwo = (n - timesOfThree * 3)/2;

        return (int) (Math.pow(3,timesOfThree) * Math.pow(2, timesOfTwo));

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.cutRopeByGA(9));
    }
}
