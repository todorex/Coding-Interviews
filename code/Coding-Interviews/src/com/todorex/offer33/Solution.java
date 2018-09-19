package com.todorex.offer33;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @Author rex
 * 2018/8/8
 */
public class Solution {
    /**
     * 字节解题
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }

        return verfy(sequence, 0, sequence.length - 1);


    }

    /**
     * 验证子树
     * @param sequence
     * @param first
     * @param last
     * @return
     */
    public boolean verfy(int[] sequence, int first, int last) {
        if (first - last == 0) {
            return true;
        }
        int right = first;
        while (sequence[right] < sequence[last] && right < last) {
            right++;
        }
        int left = right;
        while (left < last) {
            if (sequence[left] < sequence[last]) {
                return false;
            }
            left++;
        }
        boolean leftTree = true;
        if (right - 1 >= first) {
            leftTree = verfy(sequence, first, right-1);
        }
        boolean rightTree = true;
        if (last - 1 > right) {
            rightTree = verfy(sequence, right, last-1);
        }
        return  leftTree && rightTree;
    }

}
