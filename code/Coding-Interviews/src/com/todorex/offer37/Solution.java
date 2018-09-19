package com.todorex.offer37;

/**
 * 序列化二叉树
 *
 * @Author rex
 * 2018/8/13
 */
public class Solution {

    int index;

    /**
     * 序列化成String(前序遍历)
     * 节点之间的分隔符是 ','
     * 空节点为'$'
     * @param root
     * @return
     */
    String serialize(BinaryTreeNode root) {
        if (root == null) {
            return "$,";
        }
        return root.value + "," + serialize(root.left) + serialize(root.right);
    }

    /**
     * 反序列化
     * @param str
     * @return
     */
    BinaryTreeNode deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        index = -1;
        String[] strNode = str.split(",");
        return deserialize(strNode);
    }

    /**
     * 真正反序列化
     * （前序遍历）
     * @param strNode
     * @return
     */
    BinaryTreeNode deserialize(String[] strNode) {
        index++;
        BinaryTreeNode treeNode = null;
        if (! strNode[index].equals("$")) {
            treeNode = new BinaryTreeNode(Integer.valueOf(strNode[index]));
            treeNode.left = deserialize(strNode);
            treeNode.right = deserialize(strNode);
        }
        return treeNode;
    }
}
