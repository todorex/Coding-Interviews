package com.todorex.offer30;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @Author rex
 * 2018/8/5
 */
public class Solution {
    /**
     * 存储数据
     */
    Stack<Integer> dataStack = new Stack<>();
    /**
     * 存储每一次的最小值
     */
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.empty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
