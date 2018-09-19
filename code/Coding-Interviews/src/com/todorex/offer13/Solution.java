package com.todorex.offer13;

/**
 * 机器人的运动范围
 *
 * @Author rex
 * 2018/7/19
 */
public class Solution {

    /**
     * 统计运动范围格子数
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 不合法判断
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        // 设置一个已访问的列表
        boolean[] visited = new boolean[rows * cols];
        // 从坐标 (0,0) 开始进入
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    /**
     * 真正的统计运动范围格子数
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;

    }

    /**
     * 检查格子是否合法
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (getDigitSum(row) + getDigitSum(col) <= threshold)) {
            return true;
        }
        return false;
    }

    /**
     * 将一个数转化为数位之和
     *
     * @param number
     * @return
     */
    public int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

}
