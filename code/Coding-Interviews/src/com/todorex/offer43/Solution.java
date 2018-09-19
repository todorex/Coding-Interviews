package com.todorex.offer43;

/**
 * 1~n整数中1出现的次数
 *
 * @Author rex
 * 2018/8/26
 */
public class Solution {
    /**
     * 规律解法
     * 按数位可能出现1的次数统计
     *
     * @param n
     * @return
     */
    public int numberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;

            // count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
            // 上面一句抵下面所有句

            int temp = a % 10;

            if (temp == 0) {
                // 情况1：当前数位为0
                count += a / 10 * m;
            } else if (temp == 1) {
                // 情况2：当前数位为1
                count += a / 10 * m + b + 1;
            } else {
                // 情况3：当前数位大于1
                count += (a / 10 + 1) * m;
            }
        }
        return count;
    }
}
