package com.yzx.sort;

/**
 * @Author YZX
 * @Create 2023-04-07 15:15
 * @Java-version jdk1.8
 */
//实现归并排序
public class Merge {

    //完成归并操作需要的辅助数组
    private static Comparable[] assist;

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        //1. 初始化辅助数组
        assist = new Comparable[a.length];
        //2. 定义lo和hi，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length-1;
        //3. 调用sort重载方法，完成数组中lo到hi的元素的排序
        sort(a,lo,hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //校验
        if (lo>=hi){
            return;
        }
        //对lo到hi中间的数据进行分组
        int mid = lo+(hi-lo)/2;//获取中间索引
        //分别对每一组的数据进行排序
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        //把两个组中的数据进行合并
        merge(a,lo,mid,hi);
    }

    //从索引lo到所以mid为一个子组，从索引mid+1到索引hi为另一个子组，把数组a中的这两个子组的数据合并成一个有序的大组（从 索引lo到索引hi）
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;//指向辅助数组
        int p1 = lo;//指向前半段数组
        int p2 = mid+1;//指向后半段数组
        //遍历，移动p1和p2指针，比较对应索引处的值，放到辅助数组中
        while (p1<=mid && p2<=hi){
            //比较对应索引处的值
            if (less(a[p1],a[p2])){
                //将更小的元素放进去，同时两个指针都向后移动
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果p1指针没有走完，那么顺序移动p1指针，把剩余的数字放到辅助数组中
        while (p1<=mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果p2指针没有走完，那么顺序移动p2指针，把剩余的数字放到辅助数组中
        while (p2<=hi){
            assist[i++] = a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for (int index = lo ; index<=hi ;index++){
            a[index] = assist[index];
        }
    }

    //判断v是否小于w
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w)<0;
    }

}
