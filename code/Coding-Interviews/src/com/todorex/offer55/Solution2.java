package com.todorex.offer55;

/**
 * 平衡二叉树
 *
 * @Author rex
 * 2018/9/11
 */
public class Solution2 {
    /**
     * 自己解题
     * 太多重复遍历 19ms
     * @param root
     * @return
     */
    public boolean isBalanced_Solution(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left-right) > 1) {
            return false;
        }
        return isBalanced_Solution(root.left) && isBalanced_Solution(root.right);
    }

    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
