package com.todorex.offer46;



/**
 * 把数字翻译成字符串
 *
 * @Author rex
 * 2018/8/29
 */
public class Solution {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        // 防止特殊输入
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 存储动态规划中间值
        int[] dp = new int[s.length()+1];

        // 为了dp[2] += dp[0] 而设置
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            // 1. 肯定会发生
            dp[i] += dp[i-1];
            // 2. 当前位与前一位可以组成一个数字时
            if (Integer.parseInt(s.substring(i-2,i)) >=0 && Integer.parseInt(s.substring(i-2,i)) <=25) {
                dp[i] += dp[i-2];
            }


        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("2"));
    }
}
