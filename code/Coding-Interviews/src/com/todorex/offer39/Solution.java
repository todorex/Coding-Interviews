package com.todorex.offer39;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 *
 * @Author rex
 * 2018/8/15
 */
public class Solution {
    /**
     * 基于HashMap的解法
     * 时间复杂度为O(1)
     * 空间复杂度不为O(1)
     * @param array
     * @return
     */
    public int moreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int value;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
                if (array.length == 1) {
                    return array[0];
                }
            } else {
                value = map.get(array[i]);
                value = map.put(array[i], value + 1);
                if (value + 1 > array.length/2) {
                    return array[i];
                }
            }
        }
        return 0;
    }
}
