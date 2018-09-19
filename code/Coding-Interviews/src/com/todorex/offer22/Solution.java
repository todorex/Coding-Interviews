package com.todorex.offer22;


/**
 * 链表中的倒数第K个节点
 * @Author rex
 * 2018/7/26
 */
public class Solution {
    /**
     * 自己解法
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {
        // 防止空指针和k=0无意义
        if (head == null || k == 0) {
            return null;
        }
        // 第一个指针的步数
        int i = 0;
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            i++;
            if (i > k-1) {
                // 保持两个指针距离为k-1
                secondNode = secondNode.next;
            }
        }
        // 还没走到k-1步就结束了
        // 表示链表的节点总数少于k
        if (i<k-1) {
            return null;
        }
        return secondNode;
    }
}