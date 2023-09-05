package com.cy.algorithm.sort.heapsort;

import com.cy.algorithm.common.execution.Execution;
import com.cy.algorithm.common.util.StringPrint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapMaxTest {

    private HeapMax heapMax;

    private static Comparable[] arr = {0, 3, 2, 6, 8, 1, 4, 5, 7, 9, 0, 0};

    @BeforeEach
    public void init() {
        heapMax = new HeapMax(arr);
    }

    @Test
    public void test_1() {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heapMax.extractMax();
        }
        System.out.println(StringPrint.printArray(arr));
        Assertions.assertTrue(Execution.isSortedMinToMax(arr));
    }

}