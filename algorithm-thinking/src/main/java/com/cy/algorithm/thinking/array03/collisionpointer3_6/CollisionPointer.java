package com.cy.algorithm.thinking.array03.collisionpointer3_6;

/**
 * @Author: Lil-K
 * @Date: 2023/9/9
 * @Description: 对撞指针
 *
 */
public class CollisionPointer {

    public static void main(String[] args) {
//        int[] numbers = new int[]{2, 3, 7, 15};
        int[] numbers = new int[]{2,3,4};
//        int target = 9;
        int target = 6;

        int[] ints = twoSum(numbers, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i] + ",");
        }
    }

    /**
     * No.167 Two Sum II - Input Array Is Sorted
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (null == numbers)
            return new int[]{};

        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i+1,j+1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {// numbers[i] + numbers[j] > target
                j--;
            }
        }
        return new int[]{};
    }

    /**
     * No.125 Valid Palindrome
     * 验证有效回文串
     */

    /**
     * No.344 Reverse String
     * 反转字符串
     */

    /**
     * No.345 Reverse Vowels of a String
     * 字符串的反转元音
     */

    /**
     * No.11 Container With Most Water
     * 字符串的反转元音
     */
}