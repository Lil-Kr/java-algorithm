package com.cy.algorithm.thinking.array03.firstissue3_4;

import com.cy.algorithm.common.util.CommonUtil;
import com.cy.algorithm.common.util.StringPrint;

/**
 * @Author: Lil-K
 * @Date: 2023/9/22
 * @Description:
 * No-283: Move Zeroes
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 */
public class No_283_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,0,55};
//        int[] nums = {0, 1};
        moveZeroes(nums);
        System.out.println(StringPrint.printIntArray(nums));
    }

    /**
     * 遍历整个数组, 将非0元素排列在 [0...i]中
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (null == nums){
            return;
        }

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    CommonUtil.swap(nums, i, k);
                    k++;
                }else {
                    k++;
                }
            }
        }
    }
}