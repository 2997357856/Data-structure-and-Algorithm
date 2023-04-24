package com.yzx.LinearTest.LinkTest.DoublyListTest;


import com.yzx.linear.Link.DoublyList.DoublyLinkList;

/**
 * @Author YZX
 * @Create 2023-04-15 10:56
 * @Java-version jdk1.8
 */
//测试双向链表的增删改查
public class DoublyLinkListTest {
    public static void main(String[] args) {
        DoublyLinkList<String> d1 = new DoublyLinkList();
        d1.insert("张三1");
        d1.insert("张三2");
        d1.insert("张三3");
        d1.insert("张三2");
        d1.insert("张三4");
        d1.insert(2,"李四");
        for (Object name:d1){
            System.out.println(name);
        }
        System.out.println("=====================");
        System.out.println("获取2号位置索引值是："+d1.get(2));
        System.out.println("获取[张三2]索引值是："+d1.indexOf("张三2"));
        System.out.println("删除的元素是："+d1.remove(2));
        System.out.println("=====================");
        for (Object name:d1){
            System.out.println(name);
        }
        System.out.println("获取头节点元素:"+d1.getHead());
        System.out.println("获取头尾点元素:"+d1.getLast());
        System.out.println("双向线性表的长度是:"+d1.length());
    }
}
