package com.yzx.LinearTest.LinkListTest;

import com.yzx.linear.Link.SingleList.LinkList;

/**
 * @Author YZX
 * @Create 2023-04-13 16:46
 * @Java-version jdk1.8
 */
public class LinkListTest1 {
    public static void main(String[] args) {
        LinkList<String> l1 = new LinkList<>();
        l1.insert("张三1");
        l1.insert("张三2");
        l1.insert("张三3");
        l1.insert("张三4");
        for (Object name:l1){
            System.out.println(name);
        }
        l1.reverse();
        System.out.println("=====================");
        for (Object name:l1){
            System.out.println(name);
        }
    }
}
