package com.cy.algorithm.leetcode.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lil-K
 * @Date: 2023/8/24
 * @Description:
 *  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *  Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *  Input: nums = [0,1,0,3,12]
 *  Output: [1,3,12,0,0]
 *
 * Example 2:
 *  Input: nums = [0]
 *  Output: [0]
 */
public class MoveZeroes_283 {

    /**
     * 解法一
     *
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        if (nums == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 解法二: 双指针
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {
        if (nums == null) {
            return;
        }

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 解法三: 只使用一个循环
     * @param nums
     */
    public void moveZeroes_3(int[] nums) {
        if (nums == null) {
            return;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                    k++;
                }else {
                    k++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

}