package com.yzx.sort;

/**
 * @Author YZX
 * @Create 2023-04-08 10:23
 * @Java-version jdk1.8
 */
//实现快速排序
public class Quick {

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        int lo = 0 ;
        int hi = a.length-1;
        //对a数组中的所有元素进行排序
        sort(a,lo,hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //校验
        if (lo>=hi){
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组，分为左右子组
        //返回的是分界值数据所在的索引，是分界值位置变换后的索引
        int partition = partition(a, lo, hi);
        //让左子组有序，递归调用排序
        sort(a, lo, partition-1);
        //让右子组有序，因为partition已经在正确的位置上面了，所以排序的时候是partition+1
        sort(a,partition+1,hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行分组，并返回分组界限（分组那个数据）对应的索引
    private static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值，就是默认选择第一个元素
        Comparable key = a[lo];
        //定义两个指针，分别指向左右两边的数据
        int left = lo;
        int right = hi+1;
        //切分
        while (true){
            //先从右往左扫描，移动right，找到一个比分界值小的元素便停止
            //这里表示的是key更小，即当前元素更大，所以我们要继续移动
            while (less(key,a[--right])){
                //最多扫描到数组头部
                if (right == lo){
                    break;
                }
            }
            //从左往右扫描，移动left，找到一个比分界值大的元素便停止
            //这里表示的是当前元素更小，即key更大，所以我们要继续移动
            while (less(a[++left],key)){
                //最多扫描到数组的尾部
                if (left == hi){
                    break;
                }
            }
            //判断left必须小于right，如果更大就是结束遍历;否则，交换元素
            if (left>=right){
                break;
            }else {
                change(a, left, right);
            }
        }
        // 这里表明left和right已经重合了
        // 我们需要交换right和初始分界元素的索引，交换之后right就是当前分界值所在的索引位置
        change(a,lo,right);
        return right;
    }

    //判断num1是否小于num2
    private static boolean less(Comparable num1,Comparable num2) {
        return num1.compareTo(num2)<0;
    }

    //用来实现数组中i和j位置数据的交换
    public static void change(Comparable[] arr, int i , int j){
        Comparable temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }
}
