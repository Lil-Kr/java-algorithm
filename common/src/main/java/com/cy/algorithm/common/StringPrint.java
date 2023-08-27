package com.cy.algorithm.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lil-K
 * @Date: 2023/8/27
 * @Description: print
 */
public class StringPrint {

    public static String printArray(Comparable[] arr) {
        if (arr == null || arr.length <= 0)
            return "";

        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i] + ",");
        }
        res.replace(0, res.length(), StringUtils.removeEnd(res.toString(),","));
        res.append("]");
        return res.toString();
    }

}
