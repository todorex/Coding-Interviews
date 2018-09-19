package com.todorex.offer8;

/**
 * 二叉树节点
 * @Author rex
 * 2018/6/13
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    // 父节点
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
