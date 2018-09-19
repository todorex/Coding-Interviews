package com.todorex.offer10;

/**
 * 青蛙台阶问题
 * @Author rex
 * 2018/7/15
 */
public class FrogSolution {

    /**
     * 采用斐波那契解法
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        int fib = 0;
        for (int i = 3; i <= target; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}
