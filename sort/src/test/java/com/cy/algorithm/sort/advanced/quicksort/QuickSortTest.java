package com.cy.algorithm.sort.advanced.quicksort;

import com.cy.algorithm.common.StringPrint;
import com.cy.algorithm.execution.Execution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    private static Comparable[] arr = {3, 2, 6, 8, 1, 4, 5, 7};

    private static String strMatch = "[1,2,3,4,5,6,7,8]";

    @BeforeEach
    public void init() {

    }

    @Test
    public void test1() {
        QuickSortBase.quicksort(arr);
        String res1 = StringPrint.printArray(arr);
        System.out.println(res1);
        Assertions.assertEquals(strMatch, res1);

        Assertions.assertTrue(Execution.isSorted(arr));
    }

    @Test
    public void test_2() {
        Comparable[] arr = {0, 0, 0, 0, 3, 2, 6, 8, 1, 4, 5, 7, -1,-1,-2};
        QuickSortBase.quicksort(arr);
        String res1 = StringPrint.printArray(arr);
        System.out.println(res1);

        Assertions.assertTrue(Execution.isSorted(arr));
    }

    @Test
    public void test_3() {
        Comparable[] arr = {3,2};
        QuickSortBase.quicksort(arr);
        String res1 = StringPrint.printArray(arr);
        System.out.println(res1);
        Assertions.assertTrue(Execution.isSorted(arr));
    }

    @Test
    public void test_4() {
        Comparable[] arr = {2};
        QuickSortBase.quicksort(arr);
        String res1 = StringPrint.printArray(arr);
        System.out.println(res1);
        Assertions.assertTrue(Execution.isSorted(arr));
    }
}