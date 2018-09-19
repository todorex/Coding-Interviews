package com.todorex.offer26;

/**
 * 树的子结构
 * 递归
 *
 * @Author rex
 * 2018/8/1
 */
public class Solution {
    /**
     * 判断树1是否存在树2这样的子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return doesTree1HaveTree2(root1, root2) || doesTree1HaveTree2(root1.left, root2) || doesTree1HaveTree2(root1.right, root2);

    }

    /**
     * 判断树1是否存在树2这样的子树核心
     * @param root1
     * @param root2
     * @return
     */
    public boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (equal(root1.value, root2.value)) {
            return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
        }
        return false;
    }

    /**
     * 判断两个double类型是否相等
     * @param i
     * @param j
     * @return
     */
    public boolean equal(double i, double j) {
        if (Math.abs(i-j) < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }
}
