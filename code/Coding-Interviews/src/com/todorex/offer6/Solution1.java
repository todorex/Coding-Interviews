package com.todorex.offer6;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 * @Author rex
 * 2018/6/10
 */
public class Solution1 {
    /**
     * @Author rex
     * @Date 2018/6/10 下午8:09
     * @Description 从尾到头打印链表（使用头插法将链表反转）
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (listNode == null) {
            return result;
        }
        ListNode head = new ListNode();
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }
        head = head.next;
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));

    }
}
