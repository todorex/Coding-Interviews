package com.todorex.offer34;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * @Author rex
 * 2018/8/9
 */
public class Solution {
    /**
     * 参考解题
     *
     * 例子分析
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> singleResult = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPath(root, target, result, singleResult);
        return result;

    }

    public void findPath(BinaryTreeNode node, int target, ArrayList<ArrayList<Integer>>  result, ArrayList<Integer> singleResult) {
        target -= node.value;
        singleResult.add(node.value);
        // 判断是否等于目标值且是叶节点
        if (target == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(singleResult));
        }
        if (node.left != null) {
            findPath(node.left, target, result, singleResult);
        }
        if (node.right != null) {
            findPath(node.right, target, result, singleResult);
        }
        // 删除当前节点的值
        singleResult.remove(singleResult.size()-1);

    }
}
