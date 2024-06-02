package demo13_heapify;

/*
数组中的第k大的元素
堆化，然后一个一个整
这样的算法时间复杂度是？n+k*log2n

更好的解决办法为快速选择算法
*/
public class Solution1_215 {
    public int findKthLargest(int[] nums, int k) {
        heapify(nums);
        int size = nums.length;
        int value=0;
        while (k-->0){
            value = nums[0];
            swap(0,--size,nums);
            down(0,nums,size);
        }
        return value;
    }

    public  void heapify(int[] arr){
        for (int i = (arr.length - 2) / 2; i >= 0; i--)down(i,arr,arr.length);
    }
    public void down(int parent,int[] arr,int size){
        while (parent<size){
            int left = parent*2+1;
            int right = left+1;
            int max = parent;
            if(left<size&&arr[left]>arr[max])max=left;
            if(right<size&&arr[right]>arr[max])max=right;
            if (max==parent)break;
            swap(max,parent,arr);
            parent=max;
        }
    }
    public void swap(int i,int j,int[] arr){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


}
