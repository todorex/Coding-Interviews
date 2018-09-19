package com.todorex.offer28;

/**
 * 对称的二叉树
 *
 * @Author rex
 * 2018/8/3
 */
public class Solution {
    /**
     * 理解完镜像
     * 递归解法
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null || pRoot1.value != pRoot2.value) {
            return false;
        }
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
