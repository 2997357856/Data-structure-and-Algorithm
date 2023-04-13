package com.yzx.LinearTest;

import com.yzx.linear.SequenceList;

/**
 * @Author YZX
 * @Create 2023-04-08 15:47
 * @Java-version jdk1.8
 */
public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<Integer> sequenceList = new SequenceList<>(10);
        //测试插入
        sequenceList.insert(1);
        sequenceList.insert(2);
        sequenceList.insert(3);
        sequenceList.insert(2,4);
        for (Object i : sequenceList){
            System.out.println(i);
        }
        //测试获取
        int length = sequenceList.getLength();
        System.out.println("顺序表的长度为："+length);
        System.out.println("当前索引2位置的值为："+sequenceList.get(2));
        //测试删除
        Integer remove = sequenceList.remove(1);
        System.out.println("删除的名字为："+remove);
        //测试清空
        //sequenceList.clear();
        //System.out.println("顺序表的长度为："+sequenceList.getLength());



    }
}
