package com.todorex.offer40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = solution.getLeastNumbers_Solution(a,4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
