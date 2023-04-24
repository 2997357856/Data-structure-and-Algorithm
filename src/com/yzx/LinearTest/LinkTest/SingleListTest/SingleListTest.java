package com.yzx.LinearTest.LinkTest.SingleListTest;

import com.yzx.linear.Link.SingleList.LinkList;

/**
 * @Author YZX
 * @Create 2023-04-13 16:46
 * @Java-version jdk1.8
 */
//测试基本增删改查
public class SingleListTest {
    public static void main(String[] args) {
        LinkList<String> l1 = new LinkList<>();
        l1.insert("张三1");
        l1.insert("张三2");
        l1.insert("张三3");
        l1.insert("张三2");
        l1.insert("张三4");
        l1.insert(2,"李四");
        for (Object name:l1){
            System.out.println(name);
        }
        System.out.println("=====================");
        System.out.println("获取2号位置索引值是："+l1.get(2));
        System.out.println("获取[张三2]索引值是："+l1.indexOf("张三2"));
        l1.remove(2);
        System.out.println("=====================");
        for (Object name:l1){
            System.out.println(name);
        }
    }
}
