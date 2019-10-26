package com.redsun.algorithm.subarraysum;

/**
 * @author xuguangrong
 * @description 贪心算法
 * @date Created at 19:04 2019/10/19
 */
public class GreedyAlgorithm extends SubArraySum {

    public GreedyAlgorithm(int[] arr) {
        super(arr);
    }

    @Override
    public void execute() {
        /**
         * sumStart ，sumEnd 分别表示累加数组的start位和end位
         * 也相当于 sumStart 是前一次计算结果，sumEnd 是后一次计算结果
         * 这里代码中潜在的关系是
         * sumEnd = sumStart + arr[end]
         */
        int sumStart = 0;
        int sumEnd = 0;
        int minStart = 0;// 表示最小的 minStart

        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
             // 相当于构建累加数组 sumEnd 的过程，sumEnd[0..end] = sumEnd[0..end-1] + arr[end]
            sumEnd = sumEnd + arr[endIndex];

            // 寻找 minStart，minStart[j] = min(minStart[j-1],sum[0..j])
            if (sumStart < minStart) {
                minStart = sumStart;

                /**
                 * 如果此时sum[0..(endIndex - 1)](即sumStart) < minStart
                 * 则最大子数组的start只可能从endIndex开始
                 *
                 * 通俗一点就是endIndex（0~endIndex-1）之前的都已经被赋给minStart了
                 */
                this.start = endIndex;
            }

            // 更新 sumTotal
            if (sumEnd - minStart > maxSum) {
                maxSum = sumEnd - minStart;

                /**
                 * 如果maxSum值变动，说明最大子数组的end值为当前endIndex
                 */
                this.end = endIndex;
            }
            sumStart = sumStart + arr[endIndex];
        }
    }

}