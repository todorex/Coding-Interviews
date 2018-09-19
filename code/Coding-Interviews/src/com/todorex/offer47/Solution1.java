package com.todorex.offer47;

/**
 * 礼物的最大价值
 *
 * @Author rex
 * 2018/8/30
 */
public class Solution1 {

    /**
     * 动态规划解题
     *
     * @param board
     * @return
     */
    public int getMost(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int rows = board.length;
        int columns = board[0].length;
        // 辅助数组，如果可以破坏原数组，则可直接对原数组重新赋值
        int[][] temp = new int[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = board[i][j];
                if (i == 0 && j == 0) {
                    // 存入当前值
                    temp[i][j] = value;
                } else if (i == 0){
                    // 往右走
                    temp[i][j] = temp[i][j-1] + value;
                } else if (j == 0) {
                    // 往下走
                    temp[i][j] = temp[i-1][j] + value;
                } else {
                    // 挑一个最大的路径走
                    temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]) + value;
                }
            }
        }

        return temp[rows - 1][columns-1];
    }
}
