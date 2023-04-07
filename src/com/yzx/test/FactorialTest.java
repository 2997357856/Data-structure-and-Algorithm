package com.yzx.test;

/**
 * @Author YZX
 * @Create 2023-04-07 15:01
 * @Java-version jdk1.8
 */
//定义测试斐波那契数列
public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    //求n的阶乘
    public static long factorial(int n){
        if (n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
}
