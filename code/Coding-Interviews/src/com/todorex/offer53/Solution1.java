package com.todorex.offer53;

/**
 * 在排序数组中查找数字
 * @Author rex
 * 2018/9/6
 */
public class Solution1 {
    /**
     * 重复利用二分查找
     *
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int [] array , int k) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        int first = getFirstK(array, k, 0, array.length - 1);
        int last = getLastK(array, k, 0, array.length - 1);
        if (first != -1 && last != -1) {
            count = last - first + 1;
        }
        return count;
    }

    /**
     * 找到第一个K的下标
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if (middleIndex > 0 && array[middleIndex - 1] < k) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(array, k, start, end);
    }

    /**
     * 找到最后一个K的下标
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if (middleIndex < array.length - 1 && array[middleIndex + 1] > k) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,3,3,3,4,5};
        Solution solution = new Solution();
        int count = solution.getNumberOfK(array, 3);
        System.out.println(count);
    }
}
