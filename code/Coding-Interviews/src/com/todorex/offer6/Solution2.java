package com.todorex.offer6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @Author rex
 * 2018/6/10
 */
public class Solution2 {
    /**
     * @Author rex
     * @Date 2018/6/10 下午8:09
     * @Description 从尾到头打印链表（使用栈）
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (! stack.empty()) {
            result.add(stack.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));

    }
}

