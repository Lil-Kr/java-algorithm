package com.cy.algorithm.sort.advanced.quicksort;

import com.cy.algorithm.common.execution.Execution;
import com.cy.algorithm.common.util.NumberUtil;
import org.junit.jupiter.api.Test;

class QuickSort3WaysTest {

    @Test
    public void test() throws Exception {
//        int n = 1_000_000;
        int n = 100_000;
//        Comparable[] arr1 = NumberUtil.generateNearlyOrderedArray(n, 50);
        Comparable[] arr1 = NumberUtil.generateRandomArray(n, 0, 100);

        Execution.executor(QuickSort3Ways.class, "quicksort", arr1);
        System.out.println(Execution.isSortedMinToMax(arr1));
    }

}