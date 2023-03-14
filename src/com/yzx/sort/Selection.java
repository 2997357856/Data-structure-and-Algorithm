package com.yzx.sort;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-03-14 16:50
 * @Java-version jdk1.8
 */
//实现选择排序
public class Selection {
    //实现排序
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0 ; i < len; i++ ){
            //用来记录当前的比较值
            int index = i ;
            for ( int j = i+1 ; j < len; j++){
                //如果index比当前值更大（即当前值更小），则把当前值给index存储
                if (greater(arr[index],arr[j])){
                    index = j;
                }
            }
            //交换当前值为最小值
            change(arr,i,index);
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
