package demo05_recursion;

import java.util.Arrays;

public class Demo03_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
    //index为最新将要插入的数的下标
    //搜索已排序区域可以使用二分
    public static void sort(int[] arr, int index) {
        if (arr.length-1 < index) return;
        //记录：将要插入的位置
        int flag = 0;
        //记录：将要插入的数
        int a = arr[index];
        //寻找：需要插入的位置，用flag记录
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < a) {
                flag = i+1;
                break;
            }
        }
        //整体位移
        System.arraycopy(arr,flag,arr,flag+1,index-flag);
        //赋值
        arr[flag] = a;
        //递归
        sort(arr,index+1);
    }
}
