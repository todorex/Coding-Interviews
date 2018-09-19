package com.todorex.offer18;

/**
 * 删除链表重复的节点
 * @Author rex
 * 2018/7/23
 */
public class Solution2 {
    /**
     * 全面的删除
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        // 防止非法输入
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 两个指针
        ListNode preNode = null;
        ListNode node = pHead;
        while (node != null) {
            ListNode next = node.next;
            // 删除标志位
            boolean needDeleted = false;
            if (next != null && next.val == node.val) {
                needDeleted = true;
            }
            if (!needDeleted) {
                preNode = node;
                node = node.next;
            } else {
                int value = node.val;
                ListNode toBeDelete = node;
                while (toBeDelete != null && toBeDelete.val == value) {
                    next = toBeDelete.next;
                    toBeDelete = next;
                    // 考虑头指针是否存在
                    if (preNode == null) {
                        pHead = next;
                    } else {
                        preNode.next = next;
                    }
                    node = next;
                }
            }
        }
        return pHead;

    }
}
