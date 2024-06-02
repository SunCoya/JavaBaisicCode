package demo19_sort;

import java.util.ArrayList;
import java.util.Collections;

/*
* 桶排序，把不同数据存放到不同区间，对于每个区间排序，主要是桶排序可以多线程，也可以自己设置桶个数
* */
public class Demo11_BucketSort {
    public void sort(int[] nums){
        int max = nums[0];
        int min = nums[0];
        for (int i1 : nums) {
            max=Math.max(max, i1);
            min=Math.min(min, i1);
        }
        int range = (max-min)/(nums.length-1);
        range=Math.max(1,range);
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>((max-min)/range+1);
        for (int i = 0; i < ((max-min)/range+1); i++) buckets.add(new ArrayList<>());
        for (int i : nums) {buckets.get((i -min)/range).add(i);}
        int index = 0;
        for (ArrayList<Integer> arrayList : buckets) {
            Collections.sort(arrayList);
            for (Integer integer : arrayList) nums[index++] = integer;
        }
    }
}
