package com.todorex.offer36;

/**
 * 二叉搜索树与双向链表
 *
 * @Author rex
 * 2018/8/11
 */
public class Solution {
    /**
     * 关键
     */
    private BinaryTreeNode lastNode;

    /**
     * 参考解题
     * @param pRootOfTree
     * @return
     */
    public BinaryTreeNode convert(BinaryTreeNode pRootOfTree) {

        convertChild(pRootOfTree);
        BinaryTreeNode firstNode = lastNode;
        while (lastNode != null && firstNode.left !=null) {
            firstNode = firstNode.left;
        }
        return firstNode;

    }

    public void convertChild(BinaryTreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        BinaryTreeNode current = pRootOfTree;
        if (current.left != null) {
            convertChild(current.left);
        }
        // 关键
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            convertChild(current.right);
        }
    }

}
