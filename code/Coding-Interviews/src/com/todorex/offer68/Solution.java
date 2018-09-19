package com.todorex.offer68;

/**
 * 二叉搜索树中两个节点的最低公共祖先
 *
 * @Author rex
 * 2018/9/19
 */
public class Solution {
    /**
     * 获得二叉搜索树中两个节点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 防止特殊输入
        if (root == null || p == null || q == null) {
            return null;
        }
        // 最低公共祖先为从根节点往下第一个在两个输入节点之间的值的节点
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val >= min && root.val <= max) {
                return root;
            }

            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }

        }
        return null;
    }
}
