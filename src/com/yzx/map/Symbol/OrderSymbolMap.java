package com.yzx.map.Symbol;

/**
 * @Author YZX
 * @Create 2023-04-25 9:54
 * @Java-version jdk1.8
 */
//实现有序键值对，保证插入的键实现了排序的接口
//extends限制了Key，表示只能实现Comparable的子类型
public class OrderSymbolMap<Key extends Comparable,Value> {
    //记录首节点
    private Node<Key,Value> head;
    //记录键值对中元素的个数
    private int N;

    //构造函数
    public OrderSymbolMap() {
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

    //向符号表中插入一个键值对
    //假设我们插入3，当前队列为【head->1->2->4->5】，则插入后应该为【head->1->2->3->4->5】
    public void put(Key key,Value value) {
        //1. 定义两个Node节点，记录当前节点和当前节点的上一个节点
        Node curr = head.next;
        Node pre = head;
        //2. 这里要注意：首先是判断当前节点不为空
        //其次是key的值一定要比当前键更大才能继续遍历，即 compareTo()>0
        while (curr!=null && key.compareTo(curr.key)>0){
            //变换当前节点和前一个节点即可
            pre = pre.next;
            curr = curr.next;
        }

        //3. 循环结束，表示遍历结束或找到了插入位置
            //3.1 key早已经存在，则替换值
        if (curr!=null && key.compareTo(curr.key)==0){
            curr.value = value;
            return;
        }
            //3.2 直接插入到pre后面，curr前面
        Node newNode = new Node(key,value,curr);
        pre.next = newNode;

        //4. 元素个数加一
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
