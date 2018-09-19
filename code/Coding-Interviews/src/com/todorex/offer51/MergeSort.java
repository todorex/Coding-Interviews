package com.todorex.offer51;

/**
 * 归并排序
 *
 * @Author rex
 * 2018/9/3
 */
public class MergeSort {
    /**
     * 归并排序
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int[] mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) >> 1;
            // 辅助数组
            int[] temp = new int[array.length];
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, temp, low, mid, high);
        }
        return array;
    }

    /**
     * 归并
     * @param array
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] array, int[] temp, int low, int mid, int high) {

        // 代表左边下标
        int i = low;
        // 代表右边下标
        int j = mid + 1;
        // 代表辅助数组的下标
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 如果左边有剩余元素，移入辅助数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 如果右边有剩余元素，移入辅助数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 临时数组覆盖原数组
        System.arraycopy(temp, 0, array, low, high - low + 1);

    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{5, 4, 3, 2, 1};
        mergeSort.mergeSort(a, 0, a.length - 1);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
