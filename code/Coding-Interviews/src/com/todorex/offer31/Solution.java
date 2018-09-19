package com.todorex.offer31;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * @Author rex
 * 2018/8/6
 */
public class Solution {
    /**
     * 辅助栈
     */
    Stack<Integer> stack = new Stack<>();

    /**
     * 字节解题
     * @param pushA
     * @param popA
     * @return
     */
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA ==null) {
            return false;
        }
        int pushAIndex = 0;
        int popAIndex = 0;
        while (popAIndex < popA.length) {
            if ((stack.empty() || stack.peek() != popA[popAIndex])) {
                if (pushAIndex == pushA.length) {
                    break;
                }
                stack.push(pushA[pushAIndex]);
                pushAIndex++;
            } else {
                stack.pop();
                popAIndex++;
            }
        }
        if (popAIndex == popA.length) {
            return true;
        } else {
            return false;
        }
    }
}
