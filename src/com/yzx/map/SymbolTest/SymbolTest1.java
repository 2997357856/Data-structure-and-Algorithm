package com.yzx.map.SymbolTest;

import com.yzx.map.Symbol.SymbolMap;

/**
 * @Author YZX
 * @Create 2023-04-25 10:16
 * @Java-version jdk1.8
 */
//测试键值对
public class SymbolTest1 {
    public static void main(String[] args) {
        SymbolMap<String,Integer> map = new SymbolMap<>();
        //测试插入
        map.put("张三",20);
        map.put("李四",25);
        map.put("王五",30);
        map.put("钱六",19);
        System.out.println("插入之后元素的个数为:"+map.size());
        //测试查询
        System.out.println("李四的年纪为:"+map.get("李四"));
        map.put("李四",30);
        System.out.println("插入之后元素的个数为:"+map.size());
        System.out.println("李四的年纪为:"+map.get("李四"));
        //测试删除
        map.delete("hhh");
        System.out.println("删除失败后元素的个数为:"+map.size());
        map.delete("李四");
        System.out.println("删除成功后元素的个数为:"+map.size());

    }
}
