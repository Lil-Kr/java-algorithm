package com.cy.algorithm.thinking.array.quicksort3way;

import com.cy.algorithm.common.util.CommonUtil;
import com.cy.algorithm.common.util.StringPrint;

/**
 * @Author: Lil-K
 * @Date: 2023/9/21
 * @Description: No-75. Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class No_75_SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
//        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(StringPrint.printIntArray(nums));
    }

    /**
     * 只遍历一次
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums
     */
    public static void sortColors(int[] nums) {
        if (null == nums)
            return;

        int zero = -1; // arr[0...zero] == 0
        int two = nums.length; // arr[two ... n-1] == 2

        for (int i = 0; i < two;) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                CommonUtil.swap(nums, i, --two);
            }else { // nums[i] == 0
                assert (nums[i] == 0);
                CommonUtil.swap(nums, ++zero, i++);
            }
        }
    }

}