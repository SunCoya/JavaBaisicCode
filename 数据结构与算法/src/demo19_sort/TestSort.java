package demo19_sort;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TestSort {
    @Test
    public void testSort(){
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new Demo11_BucketSort();
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
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testRadixSort(){
        String[] arr = new String[]{"195","879", "564","412", "456","663", "455", "255","996", "663"};
        new Demo12_RadixSort().sort(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testLiKou(){
        int[] arr1 = {1,1,2,2,2,3};
        new Solution2_1636().frequencySort(arr1);
    }
}
