package com.yzx.linear;


import java.util.Iterator;

/**
 * @Author YZX
 * @Create 2023-04-08 15:27
 * @Java-version jdk1.8
 */
//用来构造顺序表
public class SequenceList<T> implements Iterable{

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
        //如果当前元素的数量等于当前数组的长度
        if(N==eles.length){
            resize(2*eles.length);
        }
        //将i索引处以及后面的元素全部向后移动
        for (int index = N;index>i;index--){
            eles[index] = eles[index-1];
        }
        eles[i] = t;
        N++;
    }

    //向线性表中添加一个元素t
    public void insert(T t) {
        //如果当前元素的数量等于当前数组的长度
        if(N==eles.length){
            resize(2*eles.length);
        }
        //先将N处赋值为t，随后N自增
        eles[N]=t;
        N++;
    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i) {
        //记录i处索引的值，并且后面的值全部向前移动
        T current = eles[i];
        for (int index = i ; index<N-1; index++ ){
            eles[index] = eles[index+1];
        }
        //元素个数减一
        N--;
        //如果当前元素的数量等于当前数组的长度
        if(N<eles.length/4){
            resize(eles.length/2);
            //capacity = eles.length/2;
        }
        return current;
    }


    //根据参数的newSize，重新来设置数组的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组，用来提供复制数组
        T[] temp = eles;
        //容量翻倍
        eles = (T[]) new Object[newSize];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0 ; i<N;i++){
            eles[i] = temp[i];
        }
        //重新定义容量的大小
        capacity = newSize ;
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

    //实现遍历输出
    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int index;
        public SIterator(){
            this.index = 0;
        }
       @Override
        public boolean hasNext() {
            //表示还有下一个元素
            return index<N;
        }

        @Override
        public Object next() {
            return eles[index++];
        }
    }
}
