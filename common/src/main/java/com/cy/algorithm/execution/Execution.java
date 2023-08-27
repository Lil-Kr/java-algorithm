package com.cy.algorithm.execution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Lil-K
 * @Date: 2023/8/27
 * @Description:
 */
public class Execution {

    private Execution(){}

    public static void executor(Class clz, String method, Comparable[] arr) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Method targetMethod = clz.getMethod(method, new Class[]{Comparable[].class});
        Object[] params = new Object[]{arr};

        long startTime = System.currentTimeMillis();
        // 调用排序函数
        targetMethod.invoke(null, params);
        long endTime = System.currentTimeMillis();

        System.out.println(clz.getSimpleName()+ " : " + (endTime-startTime) + " ms" );
    }

    /**
     * 判断arr数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){
        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }

}
