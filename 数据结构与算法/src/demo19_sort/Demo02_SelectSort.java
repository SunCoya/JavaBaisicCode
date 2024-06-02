package demo19_sort;
//选择排序速度一般快于冒泡（不是插入傲！）
//每一轮都选最大的交换位置
//好的，我的选择排序就选这个了
//不稳定，可能会打乱相同值的顺序
public class Demo02_SelectSort {
    public void sort(int[] arr){
        int end = arr.length-1;
        while (end>0){
            int maxIndex = findMax(arr, end);
            swap(arr,end,maxIndex);
            end--;
        }
    }
    private void swap(int[] arr,int i,int j){
        if (i==j)return;
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    private int findMax(int[] arr,int end){
        int index = 0;
        for (int i = 1; i <= end; i++) if (arr[i]>arr[index])index=i;
        return index;
    }
}
