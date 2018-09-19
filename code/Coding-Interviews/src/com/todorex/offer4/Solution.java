package com.todorex.offer4;

/**
 * 二维数组中的查找
 * 从例子中找规律
 * @Author rex
 * 2018/6/9
 */
public class Solution {

    /**
     * @Author rex
     * @Date 2018/6/10 上午9:28
     * @Description 查找二维数组中的
     * @param target 要查找的数字
     * @param array 被查找的数组
     */
    public static boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (j >= 0 && i <= array.length - 1) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}


//    public static void main(String[] args) {
//        System.out.println(Find(5,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}));
//    }
