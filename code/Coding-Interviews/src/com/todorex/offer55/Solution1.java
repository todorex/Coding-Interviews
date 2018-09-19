package com.todorex.offer55;

/**
 * 二叉树的深度
 *
 * @Author rex
 * 2018/9/11
 */
public class Solution1 {
    /**
     * 递归
     * @param root
     * @return
     */
    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
