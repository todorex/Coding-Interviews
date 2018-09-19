package com.todorex.offer18;


/**
 * 在O(1)时间内删除链表节点
 *
 * @Author rex
 * 2018/7/23
 */
public class Solution1 {
    /**
     * 打破常规思维的链表删除方式
     *
     * @param head
     * @param toBeDeleted
     */
    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        // 两个指针否要考虑非法输入
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
            toBeDeleted.next = null;
        } else {
            // 要删除的节点是尾节点(只能遍历)
            ListNode current = head;
            while (current.next != toBeDeleted) {
                current = current.next;
            }
            current.next = null;
        }
    }
}
