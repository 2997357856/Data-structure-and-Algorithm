package com.yzx.linear.Link.SingleList;

import java.util.Iterator;

/**
 * @Author YZX
 * @Create 2023-04-13 10:24
 * @Java-version jdk1.8
 */
//实现单向链表的构造
public class LinkList<T> implements Iterable{
    //记录头节点
    private Node<T> head;
    //记录链表的长度
    private int N;

    //构造方法
    public LinkList(){
        //初始化头节点
        this.head = new Node<T>(null,null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表：原理是断开头节点的指向，并且将链表置零
    public void clear(){
        head.next = null;
    }

    //获取链表的长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取指定位置i处的元素
    public T get(int i){
        Node n = head.next;
        for (int index = 0 ; index<i ; index++){
            n = n.next;
        }
        return (T) n.item;
    }

    //向链表中插入元素
    public void insert(T t){
        //找到当前的最后一个节点
        Node n = head;
        while (n.next!=null){
            n = n.next;
        }
        //创建节点，保存元素
        Node newNode = new Node(t,null);
        //让当前最后一个节点指向新节点
        n.next = newNode;
        //元素的个数++
        N++;
    }

    //向链表的指定位置插入元素
    public void insert(int i , T t){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //找到i-1和i节点
        Node preNode = head;// i-1 节点
        for (int index = 0 ; index<=i-1 ; index++){
            preNode = preNode.next;
        }
        Node currentNode = preNode.next;// i 节点
        //创建新节点newNode
        Node newNode = new Node(t,null);
        //让i-1节点的next节点指向创建的newNode
        preNode.next = newNode;
        //将newNode的next节点指向原本的i节点
        newNode.next = currentNode;
        //元素个数++
        N++;
    }

    //删除指定位置的索引，并且返回被删除的元素
    public T remove(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //找到 i-1 、 i 、i+1 节点
        Node preNode = head ; //找到i-1
        for (int index = 0 ; index<=i-1 ; index++){
            preNode = preNode.next;
        }
        Node currentNode = preNode.next; //找到i
        Node nextNode = currentNode.next; //找到i+1
        //将i-1的next节点指向i+1即可
        preNode.next = nextNode ;
        //元素个数--
        N--;
        return (T) currentNode.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head ;
        //依次去除节点元素进行比较
        for (int i = 0;n.next!=null;i++){
            n = n.next;
            if (t.equals(n.item)){
                return i;
            }
        }
        return -1;
    }


    //实现遍历输出
    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    public class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        //获取下一个元素的值
        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    //用来反转整个链表
    public void reverse(){
        //判断当前链表如果为空，则直接返回
        if (N==0){
            return;
        }
        //如果不是空链表，调用重载反转链表
        reverse(head.next);
    }

    //反转指定节点curr，并且把当前节点返回
    //假设反转 1->2->3->4
    public Node reverse(Node curr){
        //如果反转的节点没有下一个节点，即停止反转
        //到4便停止
        if (curr.next==null){
            //直接将头节点指向当前节点
            head.next = curr;
            return curr;
        }
        /**
         * 否则递归反转当前链表节点的下一个节点,返回值节点就是链表反转后当前节点的上一个节点
         * 假设遍历到了 3 ， 则 3 的下一个节点为 4 ，反转之后 4 是 3 的 pre节点
         */
        Node pre = reverse(curr.next);
        /**
         * 这里开始设置指向：让返回的节点的下一个节点变为当前节点curr
         * 即从 3->4 变成了 3<-4
         */
        pre.next = curr;
        //把当前节点的下一个节点变为null
        curr.next = null;
        return curr;
    }
}
