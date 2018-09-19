package com.todorex.offer6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 从尾到图打印链表
 *
 * @Author rex
 * 2018/6/10
 */
public class Solution4 {
    /**
     * @Author rex
     * @Date 2018/6/10 下午8:09
     * @Description 从尾到头打印链表（使用递归）
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return result;
        }

        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(3);
        listNode.next = listNode1;
        System.out.println(printListFromTailToHead(listNode));

    }
}
