package com.yzx.map.Symbol;

import com.yzx.map.Symbol.Node;

/**
 * @Author YZX
 * @Create 2023-04-25 9:54
 * @Java-version jdk1.8
 */
//实现键值对
public class SymbolMap<Key,Value> {
    //记录首节点
    private Node<Key,Value> head;
    //记录键值对中元素的个数
    private int N;

    //构造函数
    public SymbolMap() {
        this.head = new Node<>(null, null,null);
        this.N = 0;
    }

    //根据键key，找对应的值
    public Value get(Key key) {
        //找到key所在的节点
        Node n = head;
        while (n.next!=null){
            n = n.next;
            //判断n节点的key是否为插入的节点的key
            if (n.key.equals(key)){
                return (Value) n.value;
            }
        }
        //否则就是没有找到
        return null;
    }

    //向符号表中插入一个键值对【这里是先移动，后判断，因为插入无非是覆盖或者在头结点处】
    //假设我们插入3，当前队列为【head->1->2->4->5】，则插入后应该为【head->3->1->2->4->5】
    public void put(Key key,Value value) {
        //键值对中有这个key，找到该节点覆盖
        Node n = head;
        while (n.next!=null){
            n = n.next;
            //判断n节点的key是否为插入的节点的key
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //键值对中没有这个key，那么插入新的节点，用head指向这个新的节点
        Node newNode = new Node(key,value,null);
        Node oldFirst = head.next;//获取原来的第一个节点
        head.next = newNode;//将head指向新的节点
        newNode.next = oldFirst;//将新节点链接到原来的第一个节点
        N++;
    }

    //删除键为key的键值对【这里是先判断后删除，因为需要找到待删除节点的前一个节点】
    public void delete(Key key) {
        //找到key对应的节点，将其删除
        Node n = head;
        while (n.next!=null){
            //判断n节点的下一个节点的键是否为key，如果是，则删除
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }

            //变换n
            n = n.next;
        }
    }

    //获取符号表的大小
    public int size() {
        return N;
    }
}
