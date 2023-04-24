package com.yzx.linear;

import com.yzx.linear.Link.SingleList.Node;

import java.util.Iterator;

/**
 * @Author YZX
 * @Create 2023-04-24 16:00
 * @Java-version jdk1.8
 */
//实现栈
public class Stack<T> implements Iterable{
    //记录首节点
    private Node<T> head;
    //记录栈中的元素
    private int N;

    public Stack() {
        this.head = new Node(null,null);
        N = 0;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取栈中元素的个数
    public int size() {
        return N;
    }

    //弹出栈顶元素
    public T pop() {
        //如果栈为空
        if (isEmpty()){
            return null;
        }else {
            //如果栈不为空
            Node oldFirst = head.next;//找到原先的第一个节点
            if (oldFirst==null){
                return null;
            }
            head.next = oldFirst.next;
            N--;
            return (T) oldFirst.item;
        }
    }

    //向栈中压入元素t
    public void push(T t) {
        Node newNode = new Node(t,null);
        //如果为空
        if (isEmpty()){
            head.next = newNode;
            N++;
        }else {
            //如果不为空
            Node oldFirst = head.next;//获取原来head指向的节点
            head.next = newNode;//head指向插入的节点
            newNode.next = oldFirst;//插入的节点指向原来的第一个节点
            N++;
        }

    }

    @Override
    public Iterator iterator() {
        return new StIterator();
    }

    public class StIterator implements Iterator{
        private Node n;

        public StIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
