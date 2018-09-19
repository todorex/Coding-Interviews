package com.todorex.offer58;

/**
 * 翻转单词顺序
 *
 * @Author rex
 * 2018/9/15
 */
public class Solution1 {
    /**
     * 翻转单词顺序
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        // 1. 反转整个字符串
        reverse(chars, 0, chars.length - 1);
        // 2. 反转每个单词
        int i = 0, j = 0;
        while (j <= chars.length - 1) {
            if (j == chars.length -1 || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        return new String(chars);
    }

    /**
     * 反转char数组
     * @param chars
     * @param start
     * @param end
     */
    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    /**
     * 交换char数组两个位置的值
     * @param chars
     * @param i
     * @param j
     */
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Wonderful";
        System.out.println(solution.reverseSentence(s));
    }
}
