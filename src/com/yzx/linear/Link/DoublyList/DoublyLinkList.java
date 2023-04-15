package com.yzx.linear.Link.DoublyList;

import java.util.Iterator;

/**
 * @Author YZX
 * @Create 2023-04-13 17:14
 * @Java-version jdk1.8
 */
public class DoublyLinkList<T> implements Iterable{
    //记录头节点
    private Node<T> head;
    //记录尾节点
    private Node<T> end;
    //记录链表的长度
    private int N;

    //构造方法
    public DoublyLinkList(){
        //初始化头节点和尾节点
        this.head = new Node<T>(null,null,null);
        this.end = null;
        //所以这个地方头节点和尾节点不占用长度
        this.N = 0;
    }

    //清空链表：原理是断开头节点和尾节点的指向，并且将链表置零
    public void clear(){
        head.next = null;
        end = null;
        N = 0;
    }

    //获取链表的长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取第一个元素
    public T getHead(){
        if (isEmpty()){
            return null;
        }
        return (T) head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return (T) end.item;
    }


    //向链表中插入元素(默认是尾部)
    public void insert(T t){
        //1. 如果链表为空
        if (isEmpty()){
            //1.1 创建新的节点
            Node newNode = new Node(head, null, t);
            //1.2 让新的的节点称之为尾节点
            end = newNode;
            //1.3 让头节点指向尾节点
            head.next = end;
        }else {
        //2. 如果链表不为空
            Node oldNode = end;
            //2.1 创建新的节点
            Node newNode = new Node(oldNode,null,t);
            //2.2 让当前的尾节点指向新节点
            oldNode.next = newNode;
            //2.3 让新节点成为尾节点
            end = newNode;
        }
        N++;
    }

    //向链表的指定位置插入元素
    public void insert(int i , T t){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }

        //找到 i-1 的节点
        //假如在 3 位置插入新节点，我们就是遍历从0-2，恰好可以找到2节点
        Node preNode = head;
        for (int index = 0 ; index<=i-1 ; index++){
            preNode = preNode.next;
        }
        //找到 i 位置节点
        Node currentNode = preNode.next;
        //创建新节点
        Node newNode = new Node(null,null,t);
        //修改指向
        preNode.next = newNode;
        newNode.next = currentNode;
        currentNode.pre = newNode;
        newNode.pre = preNode;
        //元素个数加一
        N++;
    }

    //删除指定位置的索引，并且返回被删除的元素
    public T remove(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //找到i位置的节点
        Node node = head;
        for (int index = 0 ;index<=i ; index++){
            node = node.next;
        }
        //找到 i+1 位置节点
        Node nextNode = node.next;
        //找到 i-1 位置节点
        Node preNode = node.pre;
        //修改指向
        preNode.next = nextNode;
        nextNode.pre = preNode;
        N--;
        return (T) node.item;
    }

    //获取指定位置i处的元素
    public T get(int i){
        Node node = head;
        for (int index = 0 ; index<=i ; index++){
            node  = node.next;
        }
        return (T) node.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node node = head;
        for (int index = 0 ; node.next != null ; index++){
            node  = node.next;
            if (t.equals(node.item)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new DIterator();
    }

    private class DIterator implements Iterator{
        private Node n;

        public DIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
