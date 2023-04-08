package com.yzx.linear;


import java.util.Iterator;

/**
 * @Author YZX
 * @Create 2023-04-08 15:27
 * @Java-version jdk1.8
 */
//用来构造顺序表
public class SequenceList<T> {

    //存储元素的数组
    private T[] eles;
    //当前线性表的长度
    private int N;
    //获得当前容量
    private int capacity;

    //构造方法
    public SequenceList(int capacity) {
        //强制类型转化
        this.eles = (T[])new Object[capacity];
        //初始化长度
        N = 0;
        //获取当前顺序表的容量
        this.capacity = capacity;
    }

    //空置线性表
    public void clear() {
        for (int index = 0 ; index<getLength();index++){
            eles[index] = null;
        }
        this.N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty() {
        return N==0;
    }

    //获取线性表中元素的个数
    public int getLength() {
        return N;
    }

    //获取线性表的容量
    public int getCapacity() {
        return capacity;
    }

    //读取并返回线性表中的第i个元素的值
    public T get(int i) {
        if (i <= 0 || i>=N){
            throw new RuntimeException("当前元素不存在");
        }
        return eles[i];
    }

    //在线性表的第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t) {
        if (i <= 0 || i > getCapacity() ){
            throw new RuntimeException("插入位置不合法");
        }
        if ( N > getCapacity() ){
            throw new RuntimeException("列表已满");
        }
        //将i索引处以及后面的元素全部向后移动
        for (int index = N-1;index>i;index--){
            eles[index] = eles[index-1];
        }
        eles[i] = t;
        N++;
    }

    //向线性表中添加一个元素t
    public void insert(T t) {
        if ( N > getCapacity()){
            throw new RuntimeException("列表已满");
        }
        //先将N处赋值为t，随后N自增
        eles[N]=t;
        N++;
    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i) {
        if (i<=0 || i>N-1){
            throw new RuntimeException("当前要删除的元素不存在");
        }
        //记录i处索引的值，并且后面的值全部向前移动
        T current = eles[i];
        for (int index = i ; index<N-1; index++ ){
            eles[index] = eles[index+1];
        }
        //元素个数减一
        N--;
        return current;
    }

    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返 回-1。
    public int indexOf(T t){
        if(t==null){
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

}
