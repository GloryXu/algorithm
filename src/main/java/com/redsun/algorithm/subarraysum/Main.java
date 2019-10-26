package com.redsun.algorithm.subarraysum;

/**
 * @author xuguangrong
 * @description main函数
 * @date Created at 19:02 2019/10/19
 */
public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{-1, 1, 2, 8, -1, 4, 1, 2, 8, -8, -4, 6, -9, 10};

        // 双循环暴力破解
        DoubleLoop doubleLoop = new DoubleLoop(array);
        doubleLoop.execute();
        System.out.println(doubleLoop);

        // 分治法
        SplitArray splitArray = new SplitArray(array);
        splitArray.execute();
        System.out.println(splitArray);

        // 贪心算法
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(array);
        greedyAlgorithm.execute();
        System.out.println(greedyAlgorithm);
    }

}
