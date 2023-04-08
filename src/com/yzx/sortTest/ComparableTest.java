package com.yzx.sortTest;

import com.yzx.sort.Student;

/**
 * @Author YZX
 * @Create 2023-03-14 11:18
 * @Java-version jdk1.8
 */
//定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable c2)完成测试
public class ComparableTest {

    public static void main(String[] args) {
        Student s1 = new Student("张三",23);
        Student s2 = new Student("李四",30);
        Comparable max = ComparableTest.getMaxFirst(s1, s2);
        Student result = ComparableTest.getMaxSecond(s1, s2);
        System.out.println(max);
        System.out.println(result);
    }

    //方法一：直接利用Comparable进行比较
    // 只有实现了Comparable接口的对象，才能被比较
    public static Comparable getMaxFirst(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>=0?c1:c2;
    }

    //方法二：直接利用学生对象定义好的方法进行比较
    public static Student getMaxSecond(Student s1,Student s2){
        return s1.compareTo(s2)>=0?s1:s2;
    }
}
