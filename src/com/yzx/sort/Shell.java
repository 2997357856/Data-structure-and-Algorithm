package com.yzx.sort;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-03-14 20:17
 * @Java-version jdk1.8
 */
//实现希尔排序
public class Shell {

    //实现排序
    public static void sort(Comparable[] arr) {
        //1. 根据数组长度来设置步长
        int len = arr.length;
        int h = 1;//设置步长
        while (h<len/2){
            h = h*2+1;//添加步长
        }
        //2. 进行希尔排序
        while (h>=1){
            //排序：如果大于等于1，则说明还需要排序
            //2.1 找到待插入的元素(第一次插入的元素恰好就是h的值，所以i=h，i为遍历索引)
            for (int i = h ; i < arr.length; i++){
                //2.2 把待插入的元素插入到有序数列中
                // 待插入元素为j，所以j=i，因为是
                for (int j = i ; j >= h ;j-=h){
                    //待插入的元素是a[j]，比较a[j]和a[j-h]
                    if (greater(arr[j-h],arr[j])){
                        //更大，交换元素
                        change(arr,j-h,j);
                    }else {
                        //找到了合适的插入位置，循环结束
                        break;
                    }
                }
            }
            //减小h的值
            h=h/2;
        }
        System.out.println(Arrays.toString(arr));

    }

    //用来实现num1和num2的数字大小比较
    public static boolean greater(Comparable num1 , Comparable num2){
        //如果返回true，则表明num1大于num2
        return num1.compareTo(num2)>0;
    }

    //用来实现数组中i和j位置数据的交换
    public static void change(Comparable[] arr, int i , int j){
        Comparable temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }
}
