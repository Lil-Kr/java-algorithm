package com.cy.algorithm.sort.advanced.merge;

import com.cy.algorithm.common.NumberUtil;
import com.cy.algorithm.execution.Execution;

import java.util.Arrays;

/**
 * @Author: Lil-K
 * @Date: 2023/8/30
 * @Description:
 */
public class MergeSort2 {


    public static void main(String[] args) throws Exception {
//        Comparable[] arr = {3,3,2,-9, -9};
        Comparable[] arr = {-1,3,2,0,-9, -9};
        int n = 500000;
        Comparable[] arr1 = NumberUtil.generateRandomArray(n, 0, n);
//        Comparable[] arr2 = arr1;

        /**
         * MergeSort2: 126 ms
         *
         */
//        Execution.executor(MergeSort2.class, "sort2", arr);
//        System.out.println(StringPrint.printArray(arr1));
        sort1(arr1);
//        System.out.println(StringPrint.printArray(arr1));
        System.out.println(Execution.isSorted(arr1));
//        Execution.executor(MergeSort2.class, "sort2", arr1);
//        Execution.executor(MergeSort2.class, "sort2", arr);


//        System.out.println(StringPrint.printArray(arr));
    }

    public static void sort1(Comparable[] arr) {
        sort1(arr, 0, arr.length - 1);
    }

    public static void sort2(Comparable[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * arr[l....r]
     * @param arr
     * @param l
     * @param r
     */
    public static void sort1(Comparable[] arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        sort1(arr, l, mid);
        sort1(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    public static void sort2(Comparable[] arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        /**
         * create temp space of arr.
         * index start from 0
         */
        Comparable[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            } else { // temp[i - l].compareTo(temp[j - l]) >= 0
                arr[k] = temp[j - l];
                j++;
            }
        }
    }
}
