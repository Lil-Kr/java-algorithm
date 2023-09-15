package com.cy.algorithm.thinking.findtable;

import com.cy.algorithm.common.util.StringPrint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class No_1_TwoSumTest {

    @Test
    void twoSum() {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ints = No_1_TwoSum.twoSum(nums, target);
        System.out.println(StringPrint.printIntArray(ints));
    }
}