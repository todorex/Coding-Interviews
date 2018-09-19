package com.todorex.offer29;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * @Author rex
 * 2018/8/4
 */
public class Solution {
    /**
     * 参考解法
     * 注重边界条件
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int row = matrix.length;
        int column = matrix[0].length;
        // 计算要遍历的圈数
        int circles = (Math.min(row,column)-1)/2+1;
        int start = 0;
        while (start < circles) {
            int endX = column - 1 - start;
            int endY = row - 1 - start;
            // 开始一圈圈打印矩阵
            // 从左到右打印一行
            for (int i = start; i <= endX; i ++) {
                list.add(matrix[start][i]);
            }
            // 从上到下打印一列（需要考虑时候有）
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            // 从右到左打印一列（需要考虑时候有）
            if (start < endY && start < endX) {
                for (int i = endX -1; i >= start; i--) {
                    list.add(matrix[endY][i]);
                }
            }
            // 从下到上打印一列（需要考虑时候有）
            if (start < endX && start < endY -1) {
                for (int i = endY - 1; i > start; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }
}
