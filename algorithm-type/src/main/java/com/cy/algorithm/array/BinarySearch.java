package com.cy.algorithm.array;

/**
 * @Author: Lil-K
 * @Date: 2023/8/23
 * @Description: 二分查找法
 */
public class BinarySearch {

    public static int binarySearch(Comparable[] nums, int n, int target) {
        /**
         * 在[l....r]的范围里寻找target
         */
        int l = 0;
        int r = n - 1;

        /**
         * 当 l == r 时, 区间 [l...r] 依然时有效的
         */
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) == 0) {
                return mid;
            }

//            if (target > nums[mid]) {
            if (nums[mid].compareTo(target) > 0) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

}