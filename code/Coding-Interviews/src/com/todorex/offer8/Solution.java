package com.todorex.offer8;

/**
 * 二叉树的下一个节点
 *
 * @Author rex
 * 2018/6/13
 */
public class Solution {

    /**
     * 寻找二叉树的下一个节点
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 第一种情况
        if (pNode.right != null) {
            TreeLinkNode rNode = pNode.right;
            while (rNode.left != null) {
                rNode = rNode.left;
            }
            return rNode;
        } else {
            // 第二种情况
            while (pNode.parent != null) {
                TreeLinkNode parentNode = pNode.parent;
                if (parentNode.left == pNode) {
                    return parentNode;
                }
                pNode = pNode.parent;

            }

        }
        return null;
    }
}
