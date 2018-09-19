package com.todorex.offer52;


/**
 * 两个链表的第一个公共节点
 *
 * @Author rex
 * 2018/9/4
 */
public class Solution1 {
    /**
     * 规律解题
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLinkedListLength(pHead1);
        int length2 = getLinkedListLength(pHead2);

        if (length1 > length2) {
            pHead1 = walkStep(pHead1, length1 - length2);
        } else {
            pHead2 = walkStep(pHead2, length2 - length1);
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 得到链表长度
     * @param pHead
     * @return
     */
    public int getLinkedListLength(ListNode pHead) {
        int length = 0;
        if (pHead == null) {
            return length;
        }
        while (pHead != null) {
            length++;
            pHead = pHead.next;
        }
        return length;
    }

    /**
     * 链表走几步
     * @param pHead
     * @param step
     * @return
     */
    public ListNode walkStep(ListNode pHead, int step) {
        while (step > 0) {
            pHead = pHead.next;
            step--;
        }
        return pHead;
    }
}
