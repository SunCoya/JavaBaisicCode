package demo19_sort;
//堆排序，时间复杂度为nlogn，前面的选择和冒泡都是n2
public class Demo04_HeapSort {
    //大顶堆从小到大排序
    private void heapify(int[]array,int size){
        for (int i = size/2-1; i >= 0; i--) down(array,i,size);
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void down(int[] arr,int parent,int size){
        while (parent<size){
            int left = parent*2+1;
            int right = left+1;
            int max = parent;
            if(left<size&&(arr[left]>arr[max]))max=left;
            if(right<size&&(arr[right]>arr[max]))max=right;
            if (max==parent)break;
            swap(arr,max,parent);
            parent=max;
        }
    }
    public void sort(int[] arr){
        heapify(arr,arr.length);
        int size = arr.length;
        while (size>1){
            swap(arr,--size,0);
            down(arr,0,size);
        }
    }
}
