package com.yzx.map.SymbolTest;

import com.yzx.map.Symbol.OrderSymbolMap;
import com.yzx.map.Symbol.SymbolMap;

/**
 * @Author YZX
 * @Create 2023-04-25 10:16
 * @Java-version jdk1.8
 */
//测试键值对
//可利用debug进行测试
public class OrderSymbolTest1 {
    public static void main(String[] args) {
        OrderSymbolMap<Integer,String> map = new OrderSymbolMap<>();
        //测试插入
        map.put(1,"南航");
        map.put(2,"南理");
        map.put(4,"西工大");
        map.put(5,"北理");

        map.put(3,"哈工大");
        System.out.println("插入之后元素的个数为:"+map.size());
        //测试查询
    }
}
