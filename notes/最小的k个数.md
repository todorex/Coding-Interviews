# 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

# 测试用例
* 功能测试（输入的数组中有相同的数字；输入的数组没有相同的数字）
* 边界值测试（输入的k等于1或者数组的长度）
* 特殊输入测试（k 小于 1； k 大于数组的长度；指向数组的指针为空指针）

# 题目考点
* 考察应聘者对时间复杂度的理解。应聘者每想出一种解法，面试官都期待他能分析出这种解法的时间复杂度是多少。

* 如果可以改变数组顺序，那么就是考察Partition函数，考察快排函数的基础。

* 如果不可以改变数组顺序，那么就是考察对堆、红黑树等数据结构的理解。



# 解题思路

## API解题
直接使用sortAPI，见自己解题，有点慢。

时间复杂度O(nlogn)

## 利用Partition函数解题
不断partition，直到找到下标k-1，然后输出前k个数字。

时间复杂度为O(n)；不好的地方在于会改变原数组。

## 利用堆解题
构建一个k大小的大顶堆，当之后的元素大于堆顶元素，则抛弃堆顶，让该元素入堆

时间复杂度为O(nlogk)，空间复杂度O(k)，适合用于处理大数据

## 利用红黑树解题
构建一个k大小的红黑树，之后的原理和堆一样

时间复杂度为O(nlogk)，空间复杂度O(k)，适合用于处理大数据

我们这里采用基于黑红树实现的数据结构TreeSet实现
# 自己解题
```Java
/**
 * 最小的 k 个数
 *
 * @Author rex
 * 2018/8/16
 */
public class Solution {
    /**
     * 直接用StreamAPI
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0) {
            return result;
        }
        if (k < 0 || k > input.length) {
            return result;
        }
        List<Integer> list = Arrays.stream(input).boxed().sorted().limit(k).collect(Collectors.toList());

        return (ArrayList<Integer>) list;

    }
}
```

240ms 好久的！！

# 参考解题
## 利用堆解题
```Java
/**
 * 最小的 k 个数
 *
 * @Author rex
 * 2018/8/23
 */
public class Solution1 {


    /**
     * 利用堆
     * @param input 数组
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 防止特殊输入
        if (input == null || input.length <= 0 || input.length < k || k < 1) {
            return list;
        }
        //构建最大堆(从非叶节点开始)
        for (int i = (k >> 1) - 1; i >= 0; i--) {
            adjustMaxHeapSort(input, i, k - 1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆
        //最终堆里的就是最小的K个数。
        int tmp;
        for (int i = k; i < input.length; i++) {
            // 第i个数小于堆顶元素，则放入堆中
            if (input[i] < input[0]) {
                tmp = input[0];
                input[0] = input[i];
                input[i] = tmp;
                adjustMaxHeapSort(input, 0, k - 1);
            }
        }
        for (int j = 0; j < k; j++) {
            list.add(input[j]);
        }
        return list;
    }

    /**
     * 调整大顶堆
     *
     * @param input 数组
     * @param pos   非叶子节点的下标
     * @param end   大顶堆的最后一个数的下标
     */
    public void adjustMaxHeapSort(int[] input, int pos, int end) {
        // 拿到左子节点
        int child = (pos << 1) + 1;
        int temp = input[pos];
        while (child <= end) {
            // 比较左右子节点
            if (child < end && input[child] < input[child + 1]) {
                child = child + 1;
            }
            if (temp < input[child]) {
                input[pos] = input[child];
                input[child] = temp;
                pos = child;
                child = (pos << 1) + 1;
            } else {
                break;
            }

        }

    }
```
15ms，贼快！！

## 利用红黑树解题
```Java
/**
 * 最小的 k 个数
 *
 * @Author rex
 * 2018/8/23
 */
public class Solution2 {
    /**
     * 利用基于红黑树实现的TreeSet
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 防止特殊输入
        if (input == null || input.length <= 0 || input.length < k || k < 1) {
            return list;
        }
        // 利用TreeSet构建一颗k大小的黑红树
        TreeSet<Integer> treeset = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            treeset.add(input[i]);
        }

        // 之后的数与红黑树最大值的比较，如果比最大值大，替换数中最大值
        for (int i = k; i < input.length; i++) {
            // 拿到树中的最大值
            int max = treeset.last();
            if (input[i] < max) {
                treeset.remove(max);
                treeset.add(input[i]);
            }
        }

        // 包装成list
        Iterator<Integer> it = treeset.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;

    }
}
```

26ms，也可以了！！

# 补充
如果面试时遇到的面试题哟多种解法，并且每种解法都各有优缺点，那么我们要向面试官问清楚题目的要求，输入的特点，从而选择最合适的解法。

# 参考
1. [java写一个堆排序（大顶堆）](https://blog.csdn.net/u010429424/article/details/77582627)
2. [优先队列实现 大小根堆 解决top k 问题](https://www.cnblogs.com/lifegoesonitself/p/3391741.html)
3. [Java 集合深入理解（17）：HashMap 在 JDK 1.8 后新增的红黑树结构](https://blog.csdn.net/u011240877/article/details/53358305#hashmap-%E5%9C%A8-jdk-18-%E4%B8%AD%E6%96%B0%E5%A2%9E%E7%9A%84%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84-%E7%BA%A2%E9%BB%91%E6%A0%91)
4. [集合Set,HashSet,TreeSet及其底层实现HashMap和红黑树;Collection总结](https://blog.csdn.net/kazei2073/article/details/79759031)
