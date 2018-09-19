package com.todorex.offer58;

/**
 * 左旋字符串
 *
 * @Author rex
 * 2018/9/15
 */
public class Solution2 {
    public String leftRotateString(String str,int n) {
        // 非法输入
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (n < 0 || n > str.length() - 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        // 1. 反转整个字符串
        reverse(chars, 0, str.length() - 1);
        // 2. 分别反转左右两部分
        reverse(chars, 0, str.length() - 1 - n);
        reverse(chars, str.length() - n , str.length() - 1);
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
}
