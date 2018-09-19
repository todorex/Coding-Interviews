package com.todorex.offer41;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @Author rex
 * 2018/8/24
 */
public class Solution {
    /**
     * 大顶堆，存储左半边元素 （需重写比较器）
     **/
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /**
     * 小顶堆，存储右半边元素，并且右半边元素都大于左半边
     **/
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    /**
     * 当前数据流读入的元素个数，用于判断奇偶
     **/
    private int count = 0;

    /**
     * 读取数据流
     *
     * @param num
     */
    public void insert(Integer num) {
        // 为了实现平衡分配，可以在数据的总数目是偶数时把数据插入最小堆，否则插入最大堆
        if ((count & 1) == 0) {
            // 在要把数据插入最小堆的时候，如果该数比最大堆的数还要小
            // 那么需要先插入最大堆，把最大堆的最大值拿出来出入到最小堆
            // 反之亦然
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        count++;
    }

    /**
     * 获取当前读取数据的中位数
     *
     * @return
     */
    public Double getMedian() {
        if ((count & 1) == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double)right.peek();
        }
    }
}
