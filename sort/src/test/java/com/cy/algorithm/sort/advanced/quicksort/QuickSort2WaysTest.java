package com.cy.algorithm.sort.advanced.quicksort;

import com.cy.algorithm.common.util.NumberUtil;
import com.cy.algorithm.common.util.StringPrint;
import com.cy.algorithm.common.execution.Execution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSort2WaysTest {

    private static Comparable[] arr = {3, 2, 6, 8, 1, 4, 5, 7};

    private static String strMatch = "[1,2,3,4,5,6,7,8]";

    @BeforeEach
    public void init() {

    }

    @Test
    public void test_1() {
        QuickSort2Ways.quicksort(arr);
        String res1 = StringPrint.printArray(arr);
        System.out.println(res1);
        Assertions.assertEquals(strMatch, res1);
        Assertions.assertTrue(Execution.isSortedMinToMax(arr));
    }

    @Test
    public void test_2() throws Exception {
//        int n = 1_000_000;
        int n = 100_000;
//        Comparable[] arr1 = NumberUtil.generateNearlyOrderedArray(n, 50);
        Comparable[] arr1 = NumberUtil.generateRandomArray(n, 0, 100);
        Comparable[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Comparable[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Comparable[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Comparable[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Execution.executor(QuickSortBase.class, "quicksort", arr1);
//        Execution.executor(InsertionSort.class, "sort", arr2);
        Execution.executor(QuickSortRandom.class, "quicksort", arr3);
        Execution.executor(QuickSort2Ways.class, "quicksort", arr4);
        Execution.executor(QuickSort3Ways.class, "quicksort", arr5);
        System.out.println(Execution.isSortedMinToMax(arr5));
    }
}