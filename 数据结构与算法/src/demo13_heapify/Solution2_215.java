package demo13_heapify;

import java.util.Arrays;

public class Solution2_215 {
    /*
    如果用小顶堆，堆有K大小，时间复杂度是？
    先堆化：再遍历：
    k+（n-k）log2k，时间复杂度即为O（n）
    */
    public int findKthLargest(int[] nums, int k) {
        MinHeap minHeap =new MinHeap(Arrays.copyOf(nums,k));
        minHeap.heapify();
        for (int i = k; i < nums.length; i++){
            //这里开始把i写成k了
            if (minHeap.peek()<nums[i]) minHeap.replace(nums[i]);
        }
        return minHeap.peek();
    }
    static class MinHeap{
        int[] arr;
        int size;
        public MinHeap(int[] arr) {
            this.arr = arr;
            this.size=arr.length;
        }
        public void  heapify(){
            if (size<2)return;
            for (int i = (size - 2) / 2; i >= 0; i--) down(i);
        }
        public void replace(int num){
            arr[0] =num;
            down(0);
        }
        public int peek(){
            return arr[0];
        }

        private void down(int parent){
            while (parent<=(size-1)/2){
                int left = parent*2+1;
                int right = left+1;
                int min = parent;
                if(left<size&&arr[left]<arr[min])min=left;
                if(right<size&&arr[right]<arr[min])min=right;
                if (min==parent)break;
                swap(min,parent);
                parent=min;
            }
        }
        private void swap(int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
