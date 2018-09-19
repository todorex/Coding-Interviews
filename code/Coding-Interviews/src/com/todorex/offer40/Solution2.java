package com.todorex.offer40;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 最小的 k 个数
 *
 * @Author rex
 * 2018/8/23
 */
public class Solution2 {
    /**
     * 利用基于红黑树实现的TreeSet
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 防止特殊输入
        if (input == null || input.length <= 0 || input.length < k || k < 1) {
            return list;
        }
        // 利用TreeSet构建一颗k大小的黑红树
        TreeSet<Integer> treeset = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            treeset.add(input[i]);
        }

        // 之后的数与红黑树最大值的比较，如果比最大值大，替换数中最大值
        for (int i = k; i < input.length; i++) {
            // 拿到树中的最大值
            int max = treeset.last();
            if (input[i] < max) {
                treeset.remove(max);
                treeset.add(input[i]);
            }
        }

        // 包装成list
        Iterator<Integer> it = treeset.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;

    }
}
