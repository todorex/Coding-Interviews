package com.todorex.offer24;

import java.util.List;

/**
 * 反转链表
 *
 * @Author rex
 * 2018/7/28
 */
public class Solution {
    /**
     * 自己解法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currHead = head;
        ListNode temp = null;
        while (head.next != null) {
            temp = currHead;
            currHead = head.next;
            head.next = currHead.next;
            currHead.next = temp;
        }
        return currHead;
    }
}
