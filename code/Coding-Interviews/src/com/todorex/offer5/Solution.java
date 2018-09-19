package com.todorex.offer5;

/**
 * 替换空格
 * @Author rex
 * 2018/6/10
 */
public class Solution {

    /**
     * @Author rex
     * @Date 2018/6/10 下午4:24
     * @Description 替换空格
     * 利用StringBuffer本身的替换
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        String string = str.toString();
        int j = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                int index = i + j * 2;
                str.replace(index, index + 1, "%20");
                j++;
            }
        }
        return str.toString();
    }
        public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("  ")));
    }

}


