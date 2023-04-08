package com.yzx.test;

import com.yzx.sort.Merge;
import com.yzx.sort.Quick;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-04-08 10:58
 * @Java-version jdk1.8
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{9,6,4,3,7,2,8,10,0};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
