package com.todorex.offer39;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 *
 * @Author rex
 * 2018/8/15
 */
public class Solution1 {
    /**
     * 基于数组特点解法
     * 投票问题
     * @param array
     * @return
     */
    public int moreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i ++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            }

            if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (checkMoreThanHalf(array,result)) {
            return result;
        } else {
            return 0;
        }


    }

    /**
     * 检查result是不是在array出现次数超过一半
     * @param array
     * @param result
     * @return
     */
    public boolean checkMoreThanHalf(int[] array, int result) {
        boolean isMoreThanHalf = false;
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times > (array.length >> 1)) {
            isMoreThanHalf =true;
        }
        return isMoreThanHalf;

    }
}
