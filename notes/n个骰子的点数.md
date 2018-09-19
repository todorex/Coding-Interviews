# 题目描述
把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

# 测试用例
* 功能测试（1、2、3、4个骰子的各点数的概率）
* 特殊输入测试（输入0）
* 性能测试（输入较大的数字，如11）。

# 题目考点
* 考察应聘者的数学建模能力。
* 考察应聘者对递归和循环的性能的理解。

# 解题思路
用两个数组来存储骰子点数的每个总数出现的次数（动态规划数组）

n个骰子，n轮

在第一轮循环中，第一个数组中的第n个数字表示骰子和为n出现的次数

在下一轮循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一轮循环中骰子点数和为n-1、n-2、n-3、n-4、n-5与n-6的次数的总和

依次类推求解。
# 自己解题
```java
/**
 * n个骰子的点数
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution {
    /**
     * 骰子最大值
     */
    int maxValue = 6;

    /**
     * 递归解法
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> result = new ArrayList<AbstractMap.Entry<Integer, Double>>();
        if (n <= 0) {
            return result;
        }
        // 结果次数
        int[] resultArray = new int[maxValue * n - n + 1];
        // 可能情况
        int total = (int)Math.pow(maxValue, n);
        // 算出次数
        probability(n, resultArray);
        for (int i = 0; i < resultArray.length; i++) {
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i + n, (double)resultArray[i] / total));
        }
        return result;
    }

    /**
     * 递归开始
     * @param n
     * @param resultArray
     */
    public void probability(int n, int[] resultArray) {
        for (int i = 1; i <= maxValue; i++) {
            probability(n, i, n, resultArray);
        }
    }

    /**
     * 递归核心
     * @param original
     * @param sum
     * @param current
     * @param resultArray
     */
    public void probability(int original, int sum, int current, int[] resultArray) {
        if (current == 1) {
            resultArray[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original, sum + i, current - 1, resultArray);
            }
        }

    }
}
```
测试通过率仅为75%，当n大于等于15，超出时间限制。
# 参考解题
```java
/**
 * n个骰子的点数
 *
 * @Author rex
 * 2018/9/18
 */
public class Solution1 {
    /**
     * 骰子最大值
     */
    int maxValue = 6;

    /**
     * 动态规划解题
     * @param n
     * @return
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> result = new ArrayList<AbstractMap.Entry<Integer, Double>>();
        if (n <= 0) {
            return result;
        }

        // 这里一定要用long型，不能用int型，数大了之后会造成int型溢出
        // 还折腾了一会
        long[][] probabilities = new long[2][maxValue * n + 1];

        // 数组转换标志
        int flag = 0;

        // 用第一个骰子初始化数组
        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            // 清空不可能出现的位
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;

        }

        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxValue * n; i++) {
            result.add(new AbstractMap.SimpleEntry<Integer, Double>(i, probabilities[flag][i] / total));
        }
        return result;

    }
}
```
需要注意的一点就是，动态规划数组要用long型，不然会有int型溢出。
