package com.cy.algorithm.thinking.find;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Lil-K
 * @Date: 2023/9/10
 * @Description:
 * No.350 求两个数组的交集 II
 */
public class IntersectionOfTwoArrays_350 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
//        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] intersection = intersect(nums1, nums2);
        String string = ArrayUtils.toString(intersection);
        System.out.println(string);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2)
            return new int[]{};

        Map<Integer, Integer> record = new TreeMap<>();
        for (int num : nums1) {
            if (!record.containsKey(num)){
                record.put(num, 1);
            }else {
                record.put(num, record.get(num) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if(record.containsKey(num) && record.get(num) > 0) {
                res.add(num);
                record.put(num, record.get(num) - 1);
            }
        }

        int[] ret = new int[res.size()];
        int index = 0;
        for (Integer num : res) {
            ret[index++] = num;
        }

        return ret;
    }

}
