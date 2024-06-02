package demo19_sort;
/*
    冒泡排序：比较稳定（不会在排序的时候打乱顺序），最好的情况也需要额外判断，记得可以记录最后一次交换来优化

*/
public class Demo01_Bubble {
    public void sort(int[] arr){
        int end=arr.length-1;
        while (true){
            int lastMove=0;
            for (int i = 0; i < end; i++) {
                if (arr[i]>arr[i+1])swap(arr,i,i+1);
                lastMove=i;
            }
            if (lastMove==0)break;
            end=lastMove;
        }
    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
