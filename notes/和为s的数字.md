# 题目一
## 题目描述
和为s的两个数字

输入一个**递增排序**的数组和一个数字s，在数组中查找两个数，使得他们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

## 测试用例
* 功能测试（数组中存在和为s的两个数；数组中不存在和为s的两个数）
* 特殊输入测试（表示数组的指针为空指针）

## 解题思路
充分数组是递增排序的性质

1. 定义两个指针，一个指向数组的第一个数字，一个指向数组的最后一个数字
2. 如果两个指针指向的数字加起来等于数字s，则返回结果
3. 如果两个指针指向的数字加起来大于数字s，则指向数组后面数字的指针左移
4. 如果两个指针指向的数字加起来小于数字s，则指向数组前面数字的指针右移

时间复杂度为O(n)
## 自己解题
```Java
/**
 * 和为s的两个数字
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution {
    /**
     * 直观的O(N2)的解法
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        // 非法输入
        if (array == null || array.length < 2) {
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;
    }
}
```
这是大家都能直接想到的解法。它的问题在于时间复杂度过高。

## 参考解题
```Java
/**
 * 和为s的两个数字
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution1 {
    /**
     * 双指针解法
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        // 非法输入
        if (array == null || array.length < 2) {
            return result;
        }
        // 定义首尾指针
        int smallIndex = 0;
        int bigIndex = array.length - 1;
        while (smallIndex < bigIndex) {
            int cur = array[smallIndex] + array[bigIndex];
            if (cur == sum) {
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                return result;
            } else if (cur > sum) {
                bigIndex--;
            } else {
                smallIndex++;
            }
        }
        return result;
    }
}
```

# 题目二
## 题目描述
和为s的连续正数序列

输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数），例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所有打印出3个连续序列1~5、4~6和7~8

## 测试用例
* 功能测试（存在和为s的连续序列，如9、100等；不存在和为s的连续序列，如0，4等）。
* 边界值测试（连续序列的最小和3）

## 解题思路
1. 定义连续正数序列的首尾节点small、big；small初始化为1，big初始化为2
2. 如果序列和等于s，则将序列输出，并改变big值，进入新一轮的查找
2. 如果序列和大于s，从序列中去掉最小的值，增大small的值，small的值最多加到s/2
3. 如果序列和小于s，big加1，然后加入到序列中

## 自己解题
懵逼态
## 参考解题
```Java
/**
 * 和为s的连续正数序列
 *
 * @Author rex
 * 2018/9/14
 */
public class Solution2 {
    /**
     * 双指针解法
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // 非法输入
        if (sum <= 0) {
            return result;
        }
        // 定义连续正数序列的首尾节点，都是递增的
        int small = 1;
        int big = 2;
        int cur = small + big;
        while (small <= sum/2 && small < big) {
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                big++;
                cur +=big;
            } else if (cur > sum) {
                cur -= small;
                small++;
            } else {
                big++;
                cur += big;
            }

        }
        return result;
    }
}
```
# 题目考点
* 考察应聘者思考复杂问题的思维能力，找规律。
* 考察应聘者的知识迁移能力。有点菜。
