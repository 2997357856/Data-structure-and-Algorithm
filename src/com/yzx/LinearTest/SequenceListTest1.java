package com.yzx.LinearTest;

import com.yzx.linear.SequenceList;

/**
 * @Author YZX
 * @Create 2023-04-12 20:03
 * @Java-version jdk1.8
 */
public class SequenceListTest1 {
    public static void main(String[] args) {
        //测试能否自动扩容
        SequenceList<String> s1  = new SequenceList<>(3);
        s1.insert("张三1");
        s1.insert("张三2");
        s1.insert("张三3");
        s1.insert("张三4");
        for (Object name:s1){
            System.out.println(name);
        }
        System.out.println("当前顺序表的容量为:"+s1.getCapacity());
        System.out.println("当前顺序表的长度为:"+s1.getLength());
    }
}
