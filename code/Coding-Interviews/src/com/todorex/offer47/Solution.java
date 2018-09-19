package com.todorex.offer47;

/**
 * 礼物的最大价值
 *
 * @Author rex
 * 2018/8/30
 */
public class Solution {

    /**
     * 递归解题
     * @param board
     * @return
     */
    public int getMost(int[][] board) {
        int i = board.length;
        int j = board[0].length;
        return getMost(board, i-1, j-1);
    }

    /**
     * 计算当前坐标下的礼物最大值
     * @param board
     * @param i
     * @param j
     * @return
     */
    public int getMost(int[][] board, int i, int j) {

        if (i == 0 && j == 0) {
            return board[i][j];
        }
        int left = 0;
        int top = 0;
        if (i >= 1) {
             top = getMost(board, i - 1, j);
        }
        if (j >= 1) {
            left =  getMost(board, i, j - 1 );
        }
        return Math.max(top,left) + board[i][j];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{3,4}};
        Solution solution = new Solution();
        int b = solution.getMost(a);
        System.out.println(b);
    }
}
