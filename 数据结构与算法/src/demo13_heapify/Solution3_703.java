package demo13_heapify;

//求数据流中的第k大元素
//解决思路：小顶堆秒了
public class Solution3_703 {
    MinHeap minHeap = new MinHeap();
    //记得把void删掉
    //有可能是空，所以一开始应该把所有的nums加进去
    public void KthLargest(int k, int[] nums) {
        minHeap.setSize(k);
        for (int num : nums)
            minHeap.offer(num);
    }

    public int add(int val) {
        //加入元素替换顶元素
        minHeap.offer(val);
        return minHeap.peek();
    }
    static class MinHeap{
        int[] arr;
        int size;
        public void setSize(int k) {
            arr = new int[k];
        }
        public int peek(){
            return arr[0];
        }
        public void replace(int val){
            if (val<=peek())return;
            arr[0] = val;
            down(0);
        }
        public void offer(int val){
            if (size==arr.length){
                replace(val);
                return;
            }
            arr[size++] = val;
            int child = size-1;
            while (child!=0){
                int parent = (child-1)/2;
                if (arr[parent]<arr[child])break;
                swap(parent,child);
                child=parent;
            }
        }
        public void down(int parent){
            //这里要小于等于。。。。
            while (parent<=(size-1)/2){
                int left = parent*2+1;
                int right = left+1;
                int min = parent;
                if (left<size&&arr[min]>arr[left])min=left;
                if (right<size&&arr[min]>arr[right])min=right;
                if (min == parent)break;
                swap(min,parent);
                parent=min;
            }
        }
        public void swap(int i,int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
