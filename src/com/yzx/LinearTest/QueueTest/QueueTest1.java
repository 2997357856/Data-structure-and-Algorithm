package com.yzx.LinearTest.QueueTest;

import com.yzx.linear.Queue;

import java.util.List;
import java.util.Stack;

/**
 * @Author YZX
 * @Create 2023-04-24 20:09
 * @Java-version jdk1.8
 */
//测试队列
public class QueueTest1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (Object n :queue){
            System.out.println(n);
        }
        System.out.println("==============");
        System.out.println("出队列："+queue.dequeue());
        System.out.println("剩余元素个数："+queue.size());
        System.out.println("==============");
        for (Object n :queue){
            System.out.println(n);
        }
    }
}
