package com.yzx.sort;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-03-14 15:55
 * @Java-version jdk1.8
 */
//实现冒泡排序
public class Bubble {

    //用来实现排序
    public static void sort(Comparable[] arr){
        int len = arr.length;
        //这里用来每次排序的数字减少一个
        for (int i = len ; i > 0 ; i--){
            //用来排序前面的数字
            for (int j = 0 ; j < i-1 ; j++){
                if (greater(arr[j],arr[j+1])){
                    change(arr,j,j+1);
                }
            }
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
