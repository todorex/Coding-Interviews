package com.todorex.offer35;


/**
 * 复杂链表的复制
 *
 * @Author rex
 * 2018/8/10
 */
public class Solution {
    /**
     * 参考解题
     * @param pHead
     * @return
     */
    public ComplexListNode clone(ComplexListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ComplexListNode current = pHead;

        // 1. 插入新节点
        while (current != null) {
            ComplexListNode clone = new ComplexListNode(current.value);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // 2. 设置复制节点的random指针
        current = pHead;
        while (current != null) {
            ComplexListNode clone = current.next;
            if (current.random != null) {
                clone.random = current.random.next;
            }
            current = clone.next;
        }

        // 3. 将原链表拆分成原始链表和复制链表
        current = pHead;
        ComplexListNode pCloneHead = pHead.next;
        while (current.next != null) {
            ComplexListNode next = current.next;
            current.next = next.next;
            current = next;
        }

        return pCloneHead;
    }

}
