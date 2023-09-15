package com.cy.algorithm.thinking.findtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lil-K
 * @Date: 2023/9/14
 * @Description:
 *  No.1 Two_Sum
 *      Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *      You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *      You can return the answer in any order.
 */
public class No_1_TwoSum {

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return:
     */
    public static int[] twoSum(int[] nums, int target) {
        if (null == nums)
            return new int[]{};

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (record.containsKey(temp)) {
                return new int[]{i, record.get(temp)};
            }
            record.put(nums[i], i);
        }
        return new int[]{};
    }

}
