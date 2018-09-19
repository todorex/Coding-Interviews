package com.todorex.offer53;

/**
 * 在排序数组中查找数字
 * @Author rex
 * 2018/9/6
 */
public class Solution {
    /**
     * 垃圾算法，还是和普通遍历一样的复杂度
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int [] array , int k) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        int index = getNumberOfKCore(array, k, 0, array.length - 1);
        int temp = index;
        while (temp >=0 && array[temp] == k) {
            count++;
            temp--;
        }
        temp = index + 1;
        while (temp <= array.length - 1 && array[temp] == k) {
            count++;
            temp++;
        }
        return count;
    }

    /**
     * 二分查找
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    public int getNumberOfKCore(int[] array, int k, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (array[mid] < k) {
            return getNumberOfKCore(array, k, start, mid - 1);
        } else if (array[mid] > k){
            return getNumberOfKCore(array, k, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,3,3,3,4,5};
        Solution solution = new Solution();
        int count = solution.getNumberOfK(array, 2);
        System.out.println(count);
    }
}
