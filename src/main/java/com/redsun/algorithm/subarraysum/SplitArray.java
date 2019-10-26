package com.redsun.algorithm.subarraysum;

/**
 * @author xuguangrong
 * @description 分治法，一个数组
 * @date Created at 19:04 2019/10/19
 */
public class SplitArray extends SubArraySum {

    public SplitArray(int[] arr) {
        super(arr);
    }

    @Override
    public void execute() {
        maxSum = findMaxChildArr(arr, 0, arr.length - 1);
    }

    /**
     * 找出最大子数组
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int findMaxChildArr(int[] arr, int left, int right) {
        if (left == right) {
            // 如果左等于右,则说明这个子数组只存在一个元素,则返回它用于比较
            return arr[left];
        } else {
            // 递归思想
            int middle = (left + right) / 2;
            // 寻找左侧数组最大值;
            int leftMax = findMaxChildArr(arr, left, middle);
            // 寻找右侧数组最大值;
            int rightMax = findMaxChildArr(arr, middle + 1, right);
            // 寻找中间最大值
            int middleMax = findMiddleMax(arr, left, right, middle);
            if (leftMax >= rightMax && leftMax >= middleMax) {
                return leftMax;
            } else if (rightMax >= leftMax && rightMax > middleMax) {
                return rightMax;
            } else {
                return middleMax;
            }
        }

    }

    /**
     * 找出中间最大的值
     *
     * @param arr
     * @param left
     * @param right
     * @param middle
     * @return
     */
    public int findMiddleMax(int[] arr, int left, int right, int middle) {
        int lmidMax = -1000;
        int rmidMax = -1000;
        int sum = 0;
        // 找到向左的最大前缀
        for (int i = middle; i >= left; i--) {
            sum += arr[i];
            if (sum > lmidMax) {
                lmidMax = sum;
            }
        }
        // 找到向右的最大后缀
        sum = 0;
        for (int i = middle + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rmidMax) {
                rmidMax = sum;
            }
        }
        return lmidMax + rmidMax;
    }
}