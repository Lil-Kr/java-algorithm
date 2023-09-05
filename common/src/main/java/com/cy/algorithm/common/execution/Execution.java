package com.cy.algorithm.common.execution;

import java.lang.reflect.Method;

/**
 * @Author: Lil-K
 * @Date: 2023/8/27
 * @Description:
 */
public class Execution {

    public static void executor(Class clz, String method, Comparable[] arr) throws Exception {

        Method targetMethod = clz.getMethod(method, new Class[]{Comparable[].class});
        Object[] params = new Object[]{arr};

        long startTime = System.currentTimeMillis();
        // 调用排序函数
        targetMethod.invoke(null, params);
        long endTime = System.currentTimeMillis();

        System.out.println(clz.getSimpleName()+ " : " + targetMethod.getName() + " : " + (endTime-startTime) + " ms" );
    }

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSortedMinToMax(Comparable[] arr) {
        for( int i = 0; i < arr.length - 1; i++)
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }

    public static boolean isSortedMaxToMin(Comparable[] arr) {
        for( int i = 0; i < arr.length - 1; i++)
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }
}
