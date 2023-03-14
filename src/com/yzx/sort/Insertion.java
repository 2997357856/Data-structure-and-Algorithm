package com.yzx.sort;

import java.util.Arrays;

/**
 * @Author YZX
 * @Create 2023-03-14 17:23
 * @Java-version jdk1.8
 */
//实现插入排序
public class Insertion {

    //实现排序
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1 ;i < len ;i++){
            // 注意越界
            // 因为我们arr[j]只需要和他的上一个值比较即可
            // 所以当j=1的时候，我们已经和j=0的数据进行了比较
            for (int j = i ; j >0 ;j--){
                //如果前一个值比当前值更大，则交换位置
                //所以我们在移动的值一直都是arr[j]
                if (greater(arr[j-1],arr[j])){
                    change(arr,j-1,j);
                }else {
                    //找不到元素，则停止
                    break;
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
