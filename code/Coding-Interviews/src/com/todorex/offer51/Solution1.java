package com.todorex.offer51;

/**
 * 数组中的逆序对
 *
 * @Author rex
 * 2018/9/3
 */
public class Solution1 {
    /**
     * 利用归并排序解题
     *
     * @param array
     * @return
     */
    public int inversePairs(int [] array) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        count = mergeSort(array, 0, array.length - 1);

        return count;

    }

    /**
     * 归并排序
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int mergeSort(int[] array, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) >> 1;
        // 辅助数组
        int[] temp = new int[array.length];
        int left = mergeSort(array, low, mid);
        int right = mergeSort(array, mid + 1, high);
        count = left + right + merge(array, temp, low, mid, high);
        return count;
    }

    /**
     * 归并
     * 在归并统计逆序对数量
     * @param array
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public int merge(int[] array, int[] temp, int low, int mid, int high) {
        int count = 0;
        // 代表左边最右端下标
        int i = mid;
        // 代表右边最右端下标
        int j = high;
        // 代表辅助数组最右端的下标
        int k = high;
        while (i >= low && j >= mid + 1) {
            if (array[i] > array[j]) {
                temp[k--] = array[i--];
                count += j - mid;
            } else {
                temp[k--] = array[j--];
            }
        }
        // 如果左边有剩余元素，移入辅助数组
        while (i >= low) {
            temp[k--] = array[i--];
        }
        // 如果右边有剩余元素，移入辅助数组
        while (j >= mid + 1) {
            temp[k--] = array[j--];
        }
        // 临时数组覆盖原数组
        System.arraycopy(temp, low, array, low, high - low + 1);

        return count;

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(solution.inversePairs(array));
    }
}
