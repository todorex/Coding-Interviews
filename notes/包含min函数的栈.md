# 题目描述
定义栈的数据，请在该类型中实现一个能够找到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

# 测试用例
* 新压入栈的数字比之前的最小值大。
* 新压入栈的数字比之前的最小值小。
* 弹出栈的数字不是最小元素。
* 弹出栈的数字是最小元素。

# 题目考点
* 考察应聘者分析复杂问题的思维能力——举例分析。
* 考察应聘者对栈的理解。

# 解题思路
这里只限制了时间复杂度，没限制空间复杂度，我们可能会想到用辅助栈。

然后我们就会想到用一个栈来保存最小值，具体怎么保存？

我们可以每次在辅助栈都压入当前数据栈的最小值。在执行min函数的时候直接取到辅助栈的栈顶元素即可，当执行push函数时，如果压入的元素比当前最小值小则压入辅助栈，不然再压入一个当前最小值（为了pop的方便），在执行pop函数时，我们只要直接弹出数据栈与辅助栈的栈顶元素就好。

# 自己解题
没有思路。

# 参考解题
```Java
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
```
