package com.todorex.offer3;

import java.util.*;

/**
 * 数组中重复的数字
 * 利用HashMap
 * @Author rex
 * 2018/6/8
 */
public class Duplicate {
    /**
     * @Author rex
     * @Date 2018/6/8 下午10:03
     * @Description 找出数组中重复的数字
     */
    public static int findDuplicate(int[] intArray) {
        // 最好设置HashMap的初始大小，防止扩容浪费时间
        Map<Integer, Integer> map = new HashMap<>(intArray.length);
        for (int i : intArray) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                return i;
            }
        }
        return -1;

    }

}
