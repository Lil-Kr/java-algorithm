package com.cy.algorithm.sort.heapsort;

import com.cy.algorithm.common.execution.Execution;
import com.cy.algorithm.common.util.NumberUtil;
import com.cy.algorithm.common.util.StringPrint;
import com.cy.algorithm.sort.advanced.quicksort.QuickSort3Ways;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapSortTest {

    private HeapSort heapSort;

    @BeforeEach
    public void init() {
        heapSort = new HeapSort();
    }

    @Test
    public void test_1() {
        Comparable[] arr = {3, 2, 6, 8, 1, 4, 5, 7};
        HeapSort.sort(arr);
        System.out.println(StringPrint.printArray(arr));
        Assertions.assertTrue(Execution.isSortedMaxToMin(arr));
    }

    @Test
    public void test_2() throws Exception {
//        int n = 1_000_000;
        int n = 100_000;
        Comparable[] arr = NumberUtil.generateRandomArray(n, 0, n);
        Comparable[] arr1 = Arrays.copyOf(arr, arr.length);

        Execution.executor(HeapSort.class, "sort", arr);
        Execution.executor(QuickSort3Ways.class, "quicksort", arr1);
        Assertions.assertTrue(Execution.isSortedMaxToMin(arr));
    }

    @Test
    public void test_3() {
        Comparable[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        HeapSort.sort(arr);
        System.out.println(StringPrint.printArray(arr));
        Assertions.assertTrue(Execution.isSortedMaxToMin(arr));
    }

}