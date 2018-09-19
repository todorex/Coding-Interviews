package com.todorex.offer59;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 活动窗口的最大值
 *
 * @Author rex
 * 2018/9/17
 */
public class Solution {
    /**
     * 双端队列解题
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> maxInWindows = new ArrayList<>();
        if (num.length >= size && size >= 1) {
            // 双端队列
            LinkedList<Integer> index = new LinkedList<>();
            // 第一个滑动窗口，保持队首为最大值
            for (int i = 0; i < size; i++) {
                // 保证队列中后面的元素比前面小
                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.pollLast();
                }
                index.offer(i);
            }
            for (int i = size; i < num.length; i++) {
                maxInWindows.add(num[index.getFirst()]);
                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.pollLast();
                }
                // 如果队首不在滑动窗口内，则从队首移除
                if (!index.isEmpty() && index.getFirst() <= (i-size)) {
                    index.pollFirst();
                }
                index.offer(i);
            }
            // 最后一个滑动窗口
            maxInWindows.add(num[index.pollFirst()]);
        }
        return maxInWindows;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = solution.maxInWindows(num,3);

        for(Integer integer : list) {
            System.out.println(integer);
        }
    }
}
