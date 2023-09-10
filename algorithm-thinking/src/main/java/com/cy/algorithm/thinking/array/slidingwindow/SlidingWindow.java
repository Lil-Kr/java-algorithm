package com.cy.algorithm.thinking.array.slidingwindow;

/**
 * @Author: Lil-K
 * @Date: 2023/9/9
 * @Description: 滑动窗口
 *
 * 本例子以 No.209 为例
 *
 * leetcode 滑动窗口练习题
 *  No.209
 *  No.438
 *  No.76
 *
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,1,2,4,1};
        int target = 8;

        int sum = minSubArrayLen(numbers, target);
        System.out.println(sum);
    }

    /**
     * No.209 Minimum Size Subarray Sum
     * 最小子数组总和
     */
    public static int minSubArrayLen(int[] numbers, int target) {
        if (null == numbers)
            return 0;

        int l = 0, r = -1;// nums[l ... r]为滑动窗口
        int sum = 0;
        int res = numbers.length + 1;// 记录长度

        while (l < numbers.length) {
            if (sum < target && (r + 1) < numbers.length) {
                r++;
                sum += numbers[r];
            }else { // sum >= target
                sum -= numbers[l];
                l++;
            }

            /**
             * 取最小的区间
             */
            if (sum >= target)
                res = Math.min(res, r - l + 1);
        }

        if (res == numbers.length + 1) {
            return 0;
        }
        return res;
    }

}
