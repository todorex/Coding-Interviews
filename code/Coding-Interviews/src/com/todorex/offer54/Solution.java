package com.todorex.offer54;

/**
 * 二叉搜索树的第K大节点
 *
 * @Author rex
 * 2018/9/8
 */
public class Solution {
    private int k;

    /**
     * 二叉搜索树的第K大节点
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode kthNode(TreeNode pRoot, int k) {
        // 防止特殊输入
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
        return kthNodeCore(pRoot);

    }

    /**
     * 中序遍历
     *
     * @param pRoot
     * @return
     */
    TreeNode kthNodeCore(TreeNode pRoot) {
        TreeNode target = null;

        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left);
        }
        // 核心
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }

        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right);
        }

        return target;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(solution.kthNode(t1, 2).val);

    }
}
