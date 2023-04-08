package com.yzx.sortTest;

import com.yzx.sort.Bubble;

/**
 * @Author YZX
 * @Create 2023-03-14 16:39
 * @Java-version jdk1.8
 */
public class BubbleTest {
    public static void main(String[] args) {
        Comparable[] arr = new Comparable[]{8 ,4, 5, 2, 3, 9, 4};
        Bubble.sort(arr);
    }
}
