package demo19_sort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class TestSort {
    @Test
    public void testSort(){
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new Demo11_BucketSort().sort(arr);
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
        int[] arr1 = {2,1,4,3,9,6,0,5,7,8,10};
        int[] arr2 = {2,1,4,3,9,6};
        new Solution1_1122().relativeSortArray(arr1,arr2);
    }
}
