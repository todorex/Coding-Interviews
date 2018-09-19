package com.todorex.offer40;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小的 k 个数
 *
 * @Author rex
 * 2018/8/23
 */
public class Solution1 {


    /**
     * 利用堆
     * @param input 数组
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 防止特殊输入
        if (input == null || input.length <= 0 || input.length < k || k < 1) {
            return list;
        }
        //构建最大堆(从非叶节点开始)
        for (int i = (k >> 1) - 1; i >= 0; i--) {
            adjustMaxHeapSort(input, i, k - 1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆
        //最终堆里的就是最小的K个数。
        int tmp;
        for (int i = k; i < input.length; i++) {
            // 第i个数小于堆顶元素，则放入堆中
            if (input[i] < input[0]) {
                tmp = input[0];
                input[0] = input[i];
                input[i] = tmp;
                adjustMaxHeapSort(input, 0, k - 1);
            }
        }
        for (int j = 0; j < k; j++) {
            list.add(input[j]);
        }
        return list;
    }

    /**
     * 调整大顶堆
     *
     * @param input 数组
     * @param pos   非叶子节点的下标
     * @param end   大顶堆的最后一个数的下标
     */
    public void adjustMaxHeapSort(int[] input, int pos, int end) {
        // 拿到左子节点
        int child = (pos << 1) + 1;
        int temp = input[pos];
        while (child <= end) {
            // 比较左右子节点
            if (child < end && input[child] < input[child + 1]) {
                child = child + 1;
            }
            if (temp < input[child]) {
                input[pos] = input[child];
                input[child] = temp;
                pos = child;
                child = (pos << 1) + 1;
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        List<Integer> list = solution1.getLeastNumbers_Solution(a,8);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
