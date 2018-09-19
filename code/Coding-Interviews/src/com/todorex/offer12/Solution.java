package com.todorex.offer12;

/**
 * 矩阵中的路径(回溯法)
 * 所谓的回溯就是对使用过的字符进行标记后和处理后的去标记
 * @Author rex
 * 2018/7/19
 */
public class Solution {
    /**
     * 判断矩阵中是否存在存在一条包含str所有字符的路径
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 防止特殊测试用例
        if (matrix == null || rows < 0 || cols <0 || str.length < 0) {
            return false;
        }
        // 定义布尔值矩阵（虽然是一个布尔值数组）
        boolean[] visited = new boolean[rows * cols];
        // 定义走到字符串的第几个字符
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 寻找一条路
     * @param matrix
     * @param rows
     * @param cols
     * @param row 当前元素行
     * @param col 当前元素列
     * @param str
     * @param pathLength 走到字符串的第几个字符
     * @param visited
     * @return
     */
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        // 超出了字符串长度
        if (pathLength > str.length-1) {
            return true;
        }
        // 定义是否有路
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            // 继续走
            ++pathLength;
            visited[row * cols + col] = true;
            // 递归下去(上下右左都看一遍)
            hasPath = hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited);
            if (!hasPath) {
                // 回溯
                --pathLength;
                visited[row * cols + col] = false;
            }

        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = new char[] {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[]  str = new char[] {'b', 'f', 'c', 'e'};
        char[]  strFalse = new char[] {'a', 'b', 'f', 'b'};
        Solution solution = new Solution();
        System.out.println(solution.hasPath(matrix,3,4,strFalse));
    }

}