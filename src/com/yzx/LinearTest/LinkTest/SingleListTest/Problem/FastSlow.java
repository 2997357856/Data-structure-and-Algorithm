package com.yzx.LinearTest.LinkTest.SingleListTest.Problem;

import com.yzx.linear.Link.SingleList.Node;

/**
 * @Author YZX
 * @Create 2023-04-15 16:15
 * @Java-version jdk1.8
 */
//实现快慢指针查找中间值
public class FastSlow {

    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
        Node<String> eight = new Node<String>("hh", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        seven.next = eight;

        System.out.println("中间值是："+getMid(first));
    }


    //查找中间值，传入的为头节点
    //原理：两个指针进行遍历，当fast移动到尾部的时候，slow则为中间
    public static String getMid(Node head){
        //定义两个指针，fast一次移动两步，slow一次移动一步
        Node<String> fast = head;
        Node<String> slow = head;
        //使用两个指针进行遍历，当fast移动到尾部的时候，slow则为中间
        //保证fast不为空，且有下一个节点（避免空指针异常）
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }
}
