package com.todorex.offer56;

/**
 * 数组中唯一只出现一次的数字
 *
 * @Author rex
 * 2018/9/13
 */
public class Solution1 {
    /**
     * 数组中唯一只出现一次的数字(其他数字都出现三次)
     * @param numbers
     * @return
     * @throws Exception
     */
    public int findNumberAppearingOnce(int[] numbers) throws Exception {
        // 非法输入
        if (numbers == null || numbers.length == 0) {
            throw new Exception("invalid input");
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((numbers[i] & 1) == 1) {
                    bitSum[j]++;
                }
                numbers[i] = numbers[i] >> 1;
            }
        }
        int result = 0;
        for (int i = 31; i >=0; i--) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] number = new int[]{1,2,1,1,3,3,3};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findNumberAppearingOnce(number));
    }
}
