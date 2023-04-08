package com.yzx.sortTest;

import com.yzx.sort.Selection;

/**
 * @Author YZX
 * @Create 2023-03-14 16:59
 * @Java-version jdk1.8
 */
public class SelectTest {
    public static void main(String[] args) {
        Comparable[] arr = new Comparable[]{8 ,4, 5, 2, 3, 9, 4};
        Selection.sort(arr);
    }
}
