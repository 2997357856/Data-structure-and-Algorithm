package com.yzx.test;

import com.yzx.sort.Shell;

/**
 * @Author YZX
 * @Create 2023-04-06 19:37
 * @Java-version jdk1.8
 */
//希尔排序测试
public class ShellTest {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{7,9,3,1,7,3,9,4};
        Shell.sort(a);
    }
}
