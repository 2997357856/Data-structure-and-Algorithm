package com.yzx.LinearTest.StackTest;

import com.yzx.linear.Stack;

/**
 * @Author YZX
 * @Create 2023-04-24 16:21
 * @Java-version jdk1.8
 */
//测试栈的压入和弹出
public class StackTest1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("栈是否为空:"+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("===================");
        for (Object num:stack){
            System.out.println(num);
        }
        System.out.println("===================");
        System.out.println("栈中元素的个数为:"+(stack.isEmpty()?0:stack.size()));
        System.out.println("栈弹出元素为:"+stack.pop());
        System.out.println("===================");
        for (Object num:stack){
            System.out.println(num);
        }
        System.out.println("栈中元素的个数为:"+(stack.isEmpty()?0:stack.size()));
    }
}
