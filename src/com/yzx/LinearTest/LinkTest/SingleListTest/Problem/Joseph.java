package com.yzx.LinearTest.LinkTest.SingleListTest.Problem;

import com.yzx.linear.Link.SingleList.Node;

/**
 * @Author YZX
 * @Create 2023-04-24 10:27
 * @Java-version jdk1.8
 */
//实现约瑟夫问题
public class Joseph {
    public static void main(String[] args) {
        //1. 构建循环链表，包括四十一个节点
        Node<Integer> first = null;//记录首节点
        Node<Integer> pre = null;//记录前一个节点

        for (int i = 1; i <=41 ; i++) {
            //如果为第一个节点
            if (i==1){
                first = new Node(1,null);
                pre = first;
                continue;
            }

            //如果是中间节点,修改指向
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;

            //如果是最后一个节点
            if (i==41){
                pre.next = first;
            }
        }
        //2. 创建计数器，模拟报数
        int count = 0;

        //3. 遍历链表
        Node<Integer> n = first;//从首节点开始遍历
        Node<Integer> before = null;//记录当前节点的前一个节点
        //表示还有剩余节点（即当前节点的下一个节点不是自己）
        while (n!=n.next){
            //模拟报数
            count++;
            //当前报数是否为3
            if (count==3){
                //如果是3，删除节点，并且打印当前节点，重置count，让当前节点后移
                before.next = n.next;
                System.out.print(n.item+" ");
                count = 0;
                n = n.next;
            }else {
                //如果不是3，让before变为当前节点，当前节点后移
                before = n;
                n = n.next;
            }
        }
        System.out.println("\n剩余的元素为:"+n.item);
    }
}
