package com.cy.algorithm.sort.basesort.selectionsort;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lil-K
 * @Date: 2023/8/26
 * @Description: 选择排序
 *
 */
public class SelectionSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Comparable[] arr = {3,2,6,1,9};
        selectionSort_toMax(arr, arr.length);

        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i] + ",");
        }
        res.replace(0, res.length(), StringUtils.removeEnd(res.toString(),","));
        res.append("]");
        System.out.println(res);

        /** ================================================ **/
        selectionSort_toMin(arr, arr.length);
        res.replace(0, res.length(), "");
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i] + ",");
        }
        res.replace(0, res.length(), StringUtils.removeEnd(res.toString(),","));
        res.append("]");
        System.out.println(res);
    }

    /**
     * 选择排序
     * @param arr
     * @param n
     */
    public static void selectionSort_toMin(Comparable[] arr, int n) {
        /**
         * 寻找 [i...n) 区间里的最小值
         */
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            sawp(arr, i, minIndex);
        }
    }

    /**
     * 选择排序
     * @param arr
     * @param n
     */
    public static void selectionSort_toMax(Comparable[] arr, int n) {
        /**
         * 寻找 [i...n) 区间里的最大值
         */
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) > 0)
                    minIndex = j;
            }
            sawp(arr, i, minIndex);
        }
    }

    private static void sawp(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}