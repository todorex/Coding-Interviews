package com.todorex.offer6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到图打印链表
 *
 * @Author rex
 * 2018/6/10
 */
public class Solution3 {
    /**
     * @Author rex
     * @Date 2018/6/10 下午8:09
     * @Description 从尾到头打印链表（使用递归）
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (listNode != null) {
            result.addAll(printListFromTailToHead(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));

    }
}

