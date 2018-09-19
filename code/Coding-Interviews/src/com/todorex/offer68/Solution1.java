package com.todorex.offer68;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通树中两个节点的最低公共祖先
 *
 * @Author rex
 * 2018/9/19
 */
public class Solution1 {
    /**
     * 求二叉树中两个节点的最低公共祖先
     *
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
        ArrayList<TreeNode> pPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> qPath = new ArrayList<TreeNode>();
        // 寻找p、q路径
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        // 寻找p、q路径的最后一个公共节点
        int minLength = Math.min(pPath.size(), qPath.size());
        int LCA = 0;
        for (int i = 0; i < minLength; i++) {
            if (pPath.get(i) == qPath.get(i)) {
                LCA = i;
            }
        }
        return pPath.get(LCA);

    }

    /**
     * 查找从根节点到目标节点的路径
     *
     * @param root
     * @param target
     * @param path
     * @return
     */
    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
