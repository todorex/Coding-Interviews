package com.todorex.offer6;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 * @Author rex
 * 2018/6/10
 */
public class Solution {
    /**
     * @Author rex
     * @Date 2018/6/10 下午8:09
     * @Description 从尾到头打印链表
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();

        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for(int i = list.size()-1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));
    }
}
