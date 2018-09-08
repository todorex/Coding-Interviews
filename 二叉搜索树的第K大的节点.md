# 题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如，在下图的二叉搜索树里，按节点数值大小顺序，第三大节点的值是4。

![offer54](https://github.com/todorex/Coding-Interviews/raw/master/images/offer54.png)

# 测试用例
* 功能测试（各种形态不同的二叉搜索树）
* 边界值测试（输入k为0、1、二叉搜索树的节点数、二叉树搜索树的节点数+1）
* 特殊输入测试（指向二叉搜索树根节点的指针为空指针）

# 题目考点
* 考察应聘者的只是迁移能力，利用中序遍历解题。
* 考察应聘者对二叉搜索树和中序遍历的特点的理解。

# 解题思路
按照中序遍历的顺序遍历一个二叉搜索树。

只要熟悉中序遍历的写法，那么这道题就不难了。
# 自己解题
```java
/**
 * 二叉搜索树的第K大节点
 *
 * @Author rex
 * 2018/9/8
 */
public class Solution {
    private int k;

    /**
     * 二叉搜索树的第K大节点
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode kthNode(TreeNode pRoot, int k) {
        // 防止特殊输入
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
        return kthNodeCore(pRoot);

    }

    /**
     * 中序遍历
     *
     * @param pRoot
     * @return
     */
    TreeNode kthNodeCore(TreeNode pRoot) {
        TreeNode target = null;

        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left);
        }
        // 核心
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }

        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right);
        }

        return target;

    }
}
```
# 参考解题
见自己解题。
