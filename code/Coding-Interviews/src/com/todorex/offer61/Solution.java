package com.todorex.offer61;

import java.util.Arrays;


/**
 * 扑克牌中的顺子
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * 参考解题
     * @param numbers 0表示大小王
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        // 防止特殊输入测试
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        // 1. 数组排序
        Arrays.sort(numbers);
        // 2. 统计数组中0的个数
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else {
                break;
            }
        }
        // 3. 统计排序之后的数组中相邻数字之间的空缺总数
        int lackCount = 0;
        int temp = numbers[zeroCount];
        for (int i = zeroCount; i < numbers.length - 1; ) {
            if (numbers[i + 1] - temp == 1) {
                i++;
            } else if (numbers[i + 1] - temp == 0) {
                return false;
            } else {
                lackCount++;
            }
            temp++;
        }
        // 4. 比较0的个数和空缺总数
        if (lackCount > zeroCount) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{1, 3, 2, 6, 4};
        System.out.println(solution.isContinuous(test));
    }
}
