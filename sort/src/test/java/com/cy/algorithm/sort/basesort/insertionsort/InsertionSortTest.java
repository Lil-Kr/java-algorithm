package com.cy.algorithm.sort.basesort.insertionsort;

import com.cy.algorithm.common.execution.Execution;
import com.cy.algorithm.common.util.NumberUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    public void test_1() throws Exception {
//        int n = 10_000_000;
        int n = 10;
//        Comparable[] arr1 = NumberUtil.generateNearlyOrderedArray(n, 1);
        Comparable[] arr1 = NumberUtil.generateRandomArray(n, 0, 1);
        Execution.executor(InsertionSort.class, "sortOptimization", arr1);
        Assertions.assertTrue(Execution.isSortedMinToMax(arr1));
    }
}