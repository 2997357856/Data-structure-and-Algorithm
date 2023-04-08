package com.yzx.sortTest;

import com.yzx.sort.Insertion;
import com.yzx.sort.Shell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZX
 * @Create 2023-04-06 19:01
 * @Java-version jdk1.8
 */
//用来比较希尔排序和插入排序的效率
public class SortCompare {
    public static void main(String[] args) throws IOException {
        //用来存储读取的数据
        List<Integer> list = new ArrayList<>();
        //字节流
        FileInputStream fis = new FileInputStream("src/com/yzx/io/Num.txt");
        //字符流
        InputStreamReader isr = new InputStreamReader(fis);
        //缓冲流
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        //存储到集合
        while ((line = br.readLine())!=null){
            list.add(Integer.valueOf(line));
        }
        br.close();
        isr.close();
        fis.close();
        //将集合转化为数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        testInsert(a);//希尔排序
        testShell(a);//插入排序
    }

    //测试希尔排序的效率
    public static void testShell(Integer[] a){
        //获取开始的时间
        long start = System.currentTimeMillis();
        Shell.sort(a);
        //获取结束的时间
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的时间为:"+(end-start));
    }

    //测试插入排序的效率
    public static void testInsert(Integer[] a){
        //获取开始的时间
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        //获取结束的时间
        long end = System.currentTimeMillis();
        System.out.println("插入排序的时间为:"+(end-start));
    }
}
