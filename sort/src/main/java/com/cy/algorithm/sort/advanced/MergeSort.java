package com.cy.algorithm.sort.advanced;

import com.cy.algorithm.common.StringPrint;

import java.util.Arrays;

/**
 * @Author: Lil-K
 * @Date: 2023/8/28
 * @Description: 归并排序 nlogn
 *
 *
 */
public class MergeSort {

    public static void main(String[] args) {
//        Comparable[] arr = {3, 4, 5, 6, 7, 8, 9, 0, -1, -2};
        Comparable[] arr = {2,3,6,8,1,4,5,7};
//        Comparable[] temp = Arrays.copyOfRange(arr, 0, arr.length - 0 + 1);
//
//        System.out.println(arr.length);
//        System.out.println(temp.length);

        sort(arr,0, arr.length-1);
        System.out.println(StringPrint.printArray(arr));

//        merge(arr, 0, 0, 0);
    }

    /**
     * 递归使用归并排序, 对 arr[l...r] 的范围进行排序
     * @param arr
     */
    public static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        /**
         * 计算中间位置的 index
         */
        int mid = l + (r - l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    /**
     * 归并过程
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        /**
         * 复制一个临时空间, 这个空间是从0开始的
         */
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        /**
         *
         */
        int i = l, j = mid + 1;

        /**
         *
         */
        for (int k = l; k <= r; k++) {
            if (i > mid) {// 当k还没结束时, i > mid, 说明
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}