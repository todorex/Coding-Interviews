package com.todorex.offer7;

import java.util.*;

/**
 * 重建二叉树
 * @Author rex
 * 2018/6/11
 */
public class Solution {

    /**
     * 利用map便于直接根据先序遍历的值定位到中序遍历的索引
     */
    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * @Author rex
     * @Date 2018/6/12 下午9:21
     * @Description 构建树
     * @param pre 先序遍历序列
     * @param in 后序遍历序列
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;

    }

    /**
     * @Author rex
     * @Date 2018/6/12 下午9:20
     * @Description 递归建立树
     * @param pre 先序遍历序列
     * @param startPreIndex   子 先序遍历序列开始索引
     * @param endPreIndex  子 先序遍历序列结束索引
     * @param pre 后序遍历序列
     * @param startPreIndex   子 后序遍历序列开始索引
     * @param endPreIndex  子 后序遍历序列结束索引
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int startPreIndex, int endPreIndex,
                                                  int[] in, int startInIndex, int endInIndex) {
        if (startPreIndex > endPreIndex) {
            return null;
        }
        int rootValue = pre[startPreIndex];
        TreeNode root = new TreeNode(rootValue);
        int rootValueIndex = map.get(rootValue);
        // 需要多验证几步确定参数(用相对个数来确定索引，先序遍历序列不要直接去使用中序遍历的索引)
        root.left = reConstructBinaryTree(pre, startPreIndex + 1, rootValueIndex - startInIndex + startPreIndex, in, startInIndex, rootValueIndex - 1);
        root.right = reConstructBinaryTree(pre, rootValueIndex - startInIndex + startPreIndex + 1, endPreIndex, in, rootValueIndex + 1, endInIndex);
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(a, b));
    }

}
