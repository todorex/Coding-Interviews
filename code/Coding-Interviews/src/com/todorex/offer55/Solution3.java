package com.todorex.offer55;

/**
 * 二叉平衡树
 *
 * @Author rex
 * 2018/9/11
 */
public class Solution3 {

    /**
     * 判断是否为二叉平衡树
     * @param root
     * @return
     */
    public boolean isBalanced_Solution(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return treeDepth(root) != -1;

    }

    /**
     * 树的深度（后序遍历）
     *
     * @param root
     * @return -1：表示不是二叉平衡树
     */
    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = treeDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }

    }

}
