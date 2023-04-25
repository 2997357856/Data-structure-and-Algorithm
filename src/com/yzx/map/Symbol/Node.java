package com.yzx.map.Symbol;

/**
 * @Author YZX
 * @Create 2023-04-25 9:54
 * @Java-version jdk1.8
 */
public class Node<Key,Value> {
    //存储键
    public Key key;
    //存储值
    public Value value;
    //存储下一个节点
    public Node next;

    public Node(Key key, Value value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
