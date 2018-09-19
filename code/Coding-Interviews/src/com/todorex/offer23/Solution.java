package com.todorex.offer23;


import java.util.List;

/**
 * 链表中环的入口节点
 *
 * @Author rex
 * 2018/7/27
 */
public class Solution {

    /**
     * 获得入口节点
     * @param head
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            nodesInLoop++;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // 先移动p1，次数为环中节点的个数
        for (int i = 0; i < nodesInLoop; i++) {
            p1 = p1.next;
        }
        // 再同时移动p1，p2，当p1 = p2时，即为入口节点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 在存在环的前提下找到一快一慢两个指针相遇的节点
     * 没有找到则代码不存在环
     * @param head
     * @return
     */
    public ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            // 增强鲁棒性
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return null;
    }

}
