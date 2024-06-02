package demo19_sort;

import java.util.ArrayList;
import java.util.HashSet;

/*
* 桶排序，把不同数据存放到不同区间，对于每个区间排序，主要是桶排序可以多线程，也可以自己设置桶个数
* */
public class Demo11_BucketSort {
    public void sort(int[] arr){
        //找最大最小值做区间优化
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        ArrayList<HashSet<Integer>> buckets = new ArrayList<>(max-min+1);
        for (int i = 0; i < (max-min+1); i++) buckets.add(new HashSet<>());
        for (int i : arr) {buckets.get(i-min).add(i);}
        int index = 0;
        for (HashSet<Integer> hashSet : buckets) for (Integer integer : hashSet) arr[index++] = integer;
    }
}
