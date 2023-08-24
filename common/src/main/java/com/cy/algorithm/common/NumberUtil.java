package com.cy.algorithm.common;

/**
 * @Author: Lil-K
 * @Date: 2023/8/23
 * @Description: 生成数字工具类
 */
public class NumberUtil {

    private NumberUtil(){}

    /**
     * 生成指定范围内的整数数组
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        return arr;
    }

    /**
     * 生成顺序的整形数组
     * @param n
     * @return
     */
    public static Integer[] generateOrderedArray(int n) {
        assert n > 0;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

}
