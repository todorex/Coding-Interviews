package com.todorex.offer56;

/**
 * 数组中值出现一次的两个数字
 *
 * @Author rex
 * 2018/9/13
 */
public class Solution {

    /**
     * 找出数组中值出现一次的两个数字
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int resultExclusiveOR = 0;
        // 1. 得到数组各个数字异或的结果
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }
        // 2. 找出异或结果二进制位为1的位
        int indexBit = findFirstBitIs1(resultExclusiveOR);
        // 3. 根据二进制位为1分成两部分分别异或，得到两个只出现一次的数字
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], indexBit)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 在整数num的二进制表示中找到右边是1的位
     * @param num
     * @return
     */
    public int findFirstBitIs1(int num) {
        int indexBit = 0;
        // int为32位
        while ((num & 1) == 0 && indexBit < 32) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;

    }

    /**
     * 判断num的二进制从右边数起的第indexBit是不是1
     * @param num
     * @param indexBit 从0开始
     * @return
     */
    public boolean isBit1(int num, int indexBit) {
        return ((num >> indexBit) & 1) == 1;
    }

}
