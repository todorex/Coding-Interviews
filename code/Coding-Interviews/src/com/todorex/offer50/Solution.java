package com.todorex.offer50;



import java.util.Map;
import java.util.TreeMap;

/**
 * 第一个只出现一次的字符
 *
 * @Author rex
 * 2018/9/2
 */
public class Solution {

    /**
     * 利用TreeMap解题
     * @param str
     * @return
     */
    public char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return '\0';
        }
        Map<Character,Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for(Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstNotRepeatingChar("abaccdeff"));
    }
}
