package demo19_sort;

import java.util.Arrays;

/*
* 按出现频率升序排列，这里也可以用集合的排序方法，就不写了
* */
public class Solution2_1636 {
    public int[] frequencySort(int[] nums) {
        int[] arr = new int[201];
        for (int num : nums) {
            arr[num+100]++;
        }
        int k = 0;
        while (true){
            int index = findMinIndex(arr);
            if (index==-1)break;
            while (arr[index]--!=0){
                nums[k++]=index-100;
            }
        }
        return nums;
    }

    private int findMinIndex(int[] arr) {
        int min = -1;
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i]>0&&(min==-1||arr[i]<arr[min]))min=i;
        }
        if (min!=-1&&arr[min]<=0)return -1;
        return min;
    }
    //使用流
    public int[] frequencySort2(int[] nums) {
        int[] arr = new int[201];
        for (int num : nums) {
            arr[num+100]++;
        }
        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            int p1 = arr[o1+100];
            int p2 = arr[o2+100];
            if (p1>p2)return 1;
            else if (p1<p2)return -1;
            //从大到小排序
            else return o2-o1;
        }).mapToInt(Integer::intValue).toArray();
    }
}
