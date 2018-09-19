package com.todorex.offer66;

/**
 * 构建乘积矩阵
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * 保存中间过程很重要
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        // 从左往右累乘(但是保证B[i] = A[0]*...*A[i-1])
        for (int i = 0, temp = 1; i < n; temp *= A[i], i++) {
            B[i] = temp;
        }
        // 从右往左累乘(但是保证B[i] = B[i] * A[n-1] * ... * A[i + 1])
        for (int i = n - 1, temp = 1; i >= 0;  temp *= A[i], i--) {
            B[i] *= temp;
        }
        return B;
    }
}
