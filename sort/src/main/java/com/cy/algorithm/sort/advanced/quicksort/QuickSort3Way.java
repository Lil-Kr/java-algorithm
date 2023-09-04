package com.cy.algorithm.sort.advanced.quicksort;

import com.cy.algorithm.common.util.CommonUtil;

/**
 * @Author: Lil-K
 * @Date: 2023/9/1
 * @Description: 三路快排 --> O(n) 级别
 *
 */
public class QuickSort3Way {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        // 对于小规模数组, 使用插入排序
//        if( r - l <= 15 ){
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        CommonUtil.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                CommonUtil.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                CommonUtil.swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        CommonUtil.swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }
}