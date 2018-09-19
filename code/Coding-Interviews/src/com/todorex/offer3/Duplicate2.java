package com.todorex.offer3;

/**
 * 不修改数组找出重复的数字
 * 确保空间复杂度为O(1)
 *
 * @Author rex
 * 2018/6/9
 */
public class Duplicate2 {
    /**
     * @param intArray    输入数组
     * @param duplicaiton 将首次找到的重复数字利用duplicaiton[0] = ?存入数组
     * @return 如果输入数组无效返回false，duplicaiton[0]=-1
     * @Author rex
     * @Date 2018/6/9 下午21:19
     * @Description 找出数组中重复的数字
     */
    public static boolean findDuplicate(int[] intArray, int[] duplicaiton) {
        // 杜绝数组为空
        if (intArray.length == 0) {
            duplicaiton[0] = -1;
            return false;
        }
        // 杜绝数组有非法数字
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 1 || intArray[i] > intArray.length - 1) {
                duplicaiton[0] = -1;
                return false;
            }
        }
        int start = 1;
        int end = intArray.length - 1;

        while (end >= start) {
            // >> 右移一位相当于除以2
            int middle = ((end + start) >> 1);
            int count = countRange(intArray, start, middle);
            // 终止条件
            if (start == end) {
                if (count > 1) {
                    duplicaiton[0] = middle;
                    return true;
                } else {
                    break;
                }
            }
            if (count > (middle - start) + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }

        }
        duplicaiton[0] = -1;
        return false;

    }

    /**
     * @param intArray 输入数组
     * @param start    区间起始数字
     * @param end      区间结束数字
     * @return 个数
     * @Author rex
     * @Date 2018/6/9 下午9:27
     * @Description 统计数组在区间里数字的个数
     */
    public static int countRange(int[] intArray, int start, int end) {
        if (intArray.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i : intArray) {
            if (i >= start && i <= end) {
                count++;
            }
        }
        return count;
    }

}
//    public static void main(String[] args) {
//        int[] intArray = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
//        int[] duplication = new int[1];
//        System.out.println(findDuplicate(intArray, duplication));
//        System.out.println(duplication[0]);
//    }