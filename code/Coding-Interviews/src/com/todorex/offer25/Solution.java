package com.todorex.offer25;

/**
 * 合并两个排序的链表
 *
 * @Author rex
 * 2018/7/30
 */
public class Solution {
    /**
     * 自己解法
     * 递归实现
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode resultNode = null;
        if (list1.val < list2.val) {
            resultNode = list1;
            resultNode.next = Merge(list1.next, list2);
        } else {
            resultNode = list2;
            resultNode.next = Merge(list1, list2.next);
        }
        return resultNode;
    }
}
