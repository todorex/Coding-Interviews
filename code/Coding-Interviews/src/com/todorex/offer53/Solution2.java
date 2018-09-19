package com.todorex.offer53;

/**
 * 0 ~ n-1 缺失的数字
 *
 * @Author rex
 * 2018/9/7
 */
public class Solution2 {
    /**
     *
     * @param array 数组
     * @param n 数组程度
     * @return
     */
    public int getMissingNumber(int[] array, int n) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearch(array, 0, n - 1);

    }

    public int binarySearch(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        // 当缺失的数字在最右边
        if (array.length == end) {
            return end;
        }
        int middleIndex = (start + end) >> 1;
        if (middleIndex == array[middleIndex]) {
            return binarySearch(array, middleIndex + 1, end);
        } else {
            if ( array[middleIndex - 1] + 2 == array[middleIndex]) {
                return array[middleIndex] - 1;
            }
            return binarySearch(array, start, middleIndex -1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] array = new int[] {0,1};
        int ret = solution.getMissingNumber(array,3);
        System.out.println(ret);
    }
}
