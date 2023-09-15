package com.cy.algorithm.thinking.findtable;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lil-K
 * @Date: 2023/9/10
 * @Description: 查找
 *
 * 以 No.349 为例
 *
 * 练习题:
 *  No.350 求 两个数组的交集 II
 */
public class No_349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        /**
         * No.349
         */
//        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] intersection = intersection(nums1, nums2);
        String string = ArrayUtils.toString(intersection);
        System.out.println(string);
    }

    /**
     * No.349
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2)
            return new int[]{};

        /**
         * 整体是O(nlogn)
         */
        Set<Integer> numsSet1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            numsSet1.add(nums1[i]);
        }

        /**
         * 整体是O(nlogn)
         */
        Set<Integer> numsSet2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (numsSet1.contains(nums2[i])) //
                numsSet2.add(nums2[i]);
        }

        /**
         * 整体是O(n)
         */
        int[] res = new int[numsSet2.size()];
        int index = 0;
        for (Integer num : numsSet2) {
            res[index++] = num;
        }
        return res;
    }

}