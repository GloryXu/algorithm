package com.redsun.algorithm.subarraysum;

/**
 * @author xuguangrong
 * @description 子数组最大和
 * @date Created at 19:14 2019/10/19
 */
public abstract class SubArraySum {

    protected int start;// 开始位置
    protected int end;// 结束位置
    protected int maxSum = Integer.MIN_VALUE;// 最大和

    protected int[] arr;// 目标数组

    public SubArraySum(int[] arr) {
        this.arr = arr;
    }

    /**
     * 计算
     */
    public abstract void execute();

    @Override
    public String toString() {
        return "运行结果{" +
                "子数组起始位置=" + start +
                ", 子数组结束位置=" + end +
                ", 子数组和=" + maxSum +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(int maxSum) {
        this.maxSum = maxSum;
    }

}
