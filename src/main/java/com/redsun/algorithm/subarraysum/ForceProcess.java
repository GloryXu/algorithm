package com.redsun.algorithm.subarraysum;

/**
 * @author xuguangrong
 * @description 暴力破解
 * @date Created at 19:04 2019/10/19
 */
public class ForceProcess extends SubArraySum{

    public ForceProcess(int[] arr) {
        super(arr);
    }

    @Override
    public void execute() {
        for (int i = 0; i < arr.length; i++) {
            // 遍历从i开始的所有子数组
            for (int j = i; j < arr.length; j++) {
                int thisSum = 0;

                // 累计求和
                for (int k = i; k <= j; k++) {
                    thisSum += arr[k];
                }
                if (thisSum > maxSum) {
                    // 记录最大子数组的位置和长度
                    maxSum = thisSum;
                    start = i;
                    end = j;
                }
            }
        }
    }

    public String getAlgorithmName() {
        return "暴力破解";
    }

}
