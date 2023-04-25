package com.yzx.linear;

import com.yzx.linear.Link.SingleList.Node;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author YZX
 * @Create 2023-04-24 19:42
 * @Java-version jdk1.8
 */
//实现队列
public class Queue<T> implements Iterable{
    //记录首节点，头节点不存放元素，只会指向第一个节点
    private Node<T> head;
    //记录尾节点，存放数据，但是不指向后一个节点
    private Node<T> end;
    //记录队列中元素的个数
    private int N;

    public Queue() {
        this.head = new Node(null,null);
        this.end = null;
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

    //向队列插入元素，每次都是从末尾插入【head->1->2->3->end】
    //假设要插入4，则应该为【head->1->2->3->4->end】
    public void enqueue(T t) {
        //1. 如果当前尾节点为null，即为空链表
        if (end==null){
            //头节点直接指向尾节点
            end = new Node<>(t,null);
            head.next = end;
        }else {
            //2. 里面已经存在了元素
            Node oldEnd = end;
            //创建新的节点
            Node newNode = new Node(t,null);
            //让当前的尾节点指向新节点
            oldEnd.next = newNode;
            //让新节点成为尾节点
            end = newNode;
        }

        N++;
    }

    //从队列中拿出元素，每次都是从头部开始取
    //假设为【head->1->2->3->4->end】,则应该取出 1,变为【head->2->3->4->end】
    public T dequeue() {
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        //如果删除完毕为空列表，那么 end = null
        if (isEmpty()){
            end = null;
        }
        return (T) oldFirst.item;
    }

    @Override
    public Iterator iterator() {
        return new QuIterator();
    }

    public class QuIterator implements Iterator{
        private Node n;

        public QuIterator() {
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
