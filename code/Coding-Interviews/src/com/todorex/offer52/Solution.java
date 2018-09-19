package com.todorex.offer52;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 两个链表的第一个公共节点
 *
 * @Author rex
 * 2018/9/4
 */
public class Solution {
    /**
     * 用栈解题
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode commonNode = null;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        // JDK建议双向队列Deque优先于Stack
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        // 两个链表入栈
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        // 不断出栈比较
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                commonNode = stack1.peek();
            }
            stack1.pop();
            stack2.pop();
        }
        return commonNode;
    }
}
