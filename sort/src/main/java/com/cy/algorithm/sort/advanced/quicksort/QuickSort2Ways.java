package com.cy.algorithm.sort.advanced.quicksort;

import com.cy.algorithm.common.util.CommonUtil;

/**
 * @Author: Lil-K
 * @Date: 2023/9/1
 * @Description: 双路快排, 解决重复元素比较多的情况
 */
public class QuickSort2Ways {

    public static void quicksort(Comparable[] arr) {
        if(null == arr)
            return;

        int length = arr.length;
        /**
         * arr[l ... r]
         */
        quicksort(arr, 0, length - 1);
    }

    /**
     * 双路快排
     * @param arr
     * @param l
     * @param r
     */
    private static void quicksort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        quicksort(arr, l, p-1);
        quicksort(arr, p+1, r);
    }

    /**
     * partition 计算
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] arr, int l, int r) {
        /**
         * 获取随机点
         */
        CommonUtil.swap(arr,l,(int)(Math.random() * (r - l + 1)) + l);

        /**
         * 固定数组的第一个元素
         */
        Comparable v = arr[l];

        /**
         * 第一个元素排序之后, 正确的位置, 从0开始
         */
        int i = l + 1, j = r;

        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0)
                i++;
            while (j > l + 1 && arr[j].compareTo(v) > 0)
                j--;
            if (i > j)
                break;
            CommonUtil.swap(arr, i, j);
            i++;
            j--;
        }
        CommonUtil.swap(arr, l, j);
        return j;
    }

}