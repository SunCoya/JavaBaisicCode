package demo05_recursion;

import java.util.Arrays;
/*
* 递归冒泡排序优化
* 如果又一轮冒泡排序中，整个数组都没有发生变化，说明排序完成了
* 如果给出数组1-100，一轮冒泡排序时数组没有变化，说明排序完成，不需要再去冒泡1-99，1-98...
* 解决：定义变量，发生交换则改变变量
* 同时，也可以记录一下最后一次发生交换的位置，这个位置在下一轮冒泡排序的时候就意味着有序与无序的分界线
* */
public class Demo02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 8, 0, 6, 2, 1, 4, 7};
        sort2(arr, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //普通版本
    public static void sort(int[] arr, int end) {
        if (end==0)return;
        for (int i = 0; i < end; i++) {
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        sort(arr,end-1);
    }

    public static void sort2(int[] arr, int end) {
        if (end==0)return;
        //在循环外定义
        int index = 0;
        for (int i = 0; i < end; i++) {
            if(arr[i]>arr[i+1]){
                //有改变则记录
                index = i;
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        //判断是否为0（）这句话不用写，如果是0再去遍历也会停止
        //if (index==0)return;
        //不为0，则到有序无序分界排序
        sort(arr,index);
    }
}
