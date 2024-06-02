package demo19_sort;
//希尔排序时间复杂度也是nlogn，但是比堆排序稍稍牛一点点


public class Demo05_Shell {
    public static void sort(int[] a){
        //希尔排序，间隙不断减小（除以二）三层循环
        //在插入排序的基础上（一个一个往后移，不是交换着后移），在外套一层gap就可以
        //网上说有更好的使用克努特序列选择间隔，这里不去了解
        for (int gap = a.length>>>1;gap>=1;gap>>>=1){
            for (int i = gap;i<a.length;i++){
                int insert = a[i];
                int j=i-gap;
                while (j>=0&&insert<a[j]){
                    a[j+gap]=a[j];
                    j-=gap;
                }
                if (j!=i-gap)a[j+gap]=insert;
            }
        }
    }
}
