package com.yzx.linear.Link.DoublyList;

/**
 * @Author YZX
 * @Create 2023-04-13 17:13
 * @Java-version jdk1.8
 */
public class Node<T> {
    //下一个节点
    public Node next;
    //上一个节点
    public Node pre;
    //存储数据
    public T item;

    //构造函数
    public Node(Node pre, Node next, T item) {
        this.pre = pre;
        this.next = next;
        this.item = item;
    }
}
