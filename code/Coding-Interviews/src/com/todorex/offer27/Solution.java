package com.todorex.offer27;

/**
 * 二叉树的镜像
 *
 * @Author rex
 * 2018/8/2
 */
public class Solution {
    /**
     * 自己解法
     * 递归
     * @param root
     */
    public void mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            BinaryTreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }
}
