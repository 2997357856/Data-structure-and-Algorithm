package com.yzx.test;

import com.yzx.sort.Merge;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-04-07 15:51
 * @Java-version jdk1.8
 */
//测试归并排序
public class MergeTest {


    public static void main(String[] args) {
        Integer[] a = new Integer[]{9,6,4,3,7,2,8};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
