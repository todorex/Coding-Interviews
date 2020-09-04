package com.todorex.offer9;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @Author rex
 * 2018/6/17
 */
public class BuildQueue1 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new Exception("queue is empty");

        }
        return stack2.pop();

    }
}
