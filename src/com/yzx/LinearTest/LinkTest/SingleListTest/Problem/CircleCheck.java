package com.yzx.LinearTest.LinkTest.SingleListTest.Problem;

import com.yzx.linear.Link.SingleList.Node;

/**
 * @Author YZX
 * @Create 2023-04-23 10:11
 * @Java-version jdk1.8
 */
//利用快慢指针校验单向链表是否有环
public class CircleCheck {

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

        //创造环
        //seven.next = third;

        System.out.println("链表是否有环："+isCircle(first));
        System.out.println("链表环的入口为："+getEntrance(first).item);
    }

    /**
     * @description 校验链表是否有环
     * 原理：因为快指针始终走比慢指针快，那么如果有环，则一定会相遇，即如果快慢指针指向了同一个节点，证明有环的
     * @date 2023/4/23 10:17
     * @params [head]头节点
     * @returns boolean 返回是否有环
     */
    public static boolean isCircle(Node<String> head){
        //定义快慢指针
        Node<String> fast = head;
        Node<String> slow = head;

        //遍历链表，如果快慢指针指向了同一个节点，那么证明有环
        while (fast!=null && fast.next!=null){
            //变换fast和slow指向
            fast = fast.next.next;
            slow = slow.next;

            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /**
     * @description 找到有环链表的入口
     * 原理：当快慢指针相遇时，我们可以判断到链表中有环，这时重新设定一个新指针指向链表的起点，
     * 且步长与慢指针一样为1，则慢指针与“新”指针相遇的地方就是环的入口
     * @date 2023/4/24 9:49
     * @params [head] 头节点
     * @returns Node 返回入口的值
     */
    public static Node getEntrance(Node<String> head){
        //定义快慢指针
        Node<String> fast = head;
        Node<String> slow = head;
        Node<String> temp = null;
        //遍历链表，先找到环，随后准备一个临时指针指向链表的首节点
        //继续遍历，当临时指针和慢指针相遇的时候，指向的节点就是环的入口
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            //判断快慢指针是否相遇
            if (fast.equals(slow)){
                temp = head;
                continue;
            }

            //判断慢指针是否和临时指针相遇
            if (temp!=null){
                temp = temp.next;
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }
}
