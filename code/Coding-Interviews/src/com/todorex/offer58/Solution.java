package com.todorex.offer58;

/**
 * 翻转单词顺序
 *
 * @Author rex
 * 2018/9/15
 */
public class Solution {
    /**
     * 需要额外空间
     *
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] temp = str.split(" ");
        if (temp.length == 0) {
            return str;
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = " ";
        System.out.println(solution.reverseSentence(s));
    }
}
