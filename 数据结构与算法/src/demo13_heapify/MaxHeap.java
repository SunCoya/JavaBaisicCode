package demo13_heapify;
import java.util.Arrays;
/*
把数组变成堆-建堆
算法：堆化算法：从最后一个非叶子节点开始，从下到上，依次下潜
假如有三层1234567，每一层的交换次数为4*0+2*1+1*2  ->  2^2*0+2^1*1+2^0*2 ->(2^h/2^i)*(i-1)的和
层数一层一层长，每一层的数量确是指数级别上升，交换次数确一个一个的加
最终结果为(h为高度)2^h-h-1，复杂度接近O(n)
从上往下可以不可以？当然也行

堆排序：首先堆化，再把堆顶与堆底部交换-不看堆底然后下潜，直到堆里只剩下一个元素，从小到大排序
*/
public class MaxHeap {
    int[] arr;
    int size;
    public MaxHeap(int capacity) {
        arr= new int[capacity+1];
    }

    //用于大顶堆
    boolean max=true;

    public MaxHeap(int[] arr) {
        this.arr = arr;
        this.size=arr.length;
    }

    public void heapify(){
        //最后一个非叶子节点就是（size-2）/2，也可以是size/2-1
        for (int i = (size-2)/2; i >= 0; i--) down(i);
    }
    public void sort(){
        int record = size;
        while (size>1){
            swap(--size,0);
            down(0);
        }
        size=record;
    }
    private void swap(int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public int poll(){
        int value = arr[0];
        swap(0,--size);
        down(0);
        return value;
    }
    public int poll(int index){
        int value = arr[index];
        swap(index,--size);
        down(index);
        return value;
    }
    public void replace(int num){
        arr[0]=num;
        down(0);
    }
    public int peek(){
        return arr[0];
    }

    private void down(int parent){
        while(parent<size){
            int left = parent*2+1;
            int right = left+1;
            int max = parent;
            //大小顶堆不一样的操作
            if(left<size&&(this.max?arr[left]>arr[max]:arr[left]<arr[max]))max=left;
            if(right<size&&(this.max?arr[right]>arr[max]:arr[right]<arr[max]))max=right;
            if (max==parent)break;
            swap(max,parent);
            parent=max;
        }
    }
    public boolean offer(int value){
        up(size++);
        return true;
    }
    private void up(int child){
        while (child!=0){
            int parent = (child-1)/2;
            //大顶堆前小顶堆后
            if (max?arr[parent]>=arr[child]:arr[parent]<=arr[child])break;
            swap(child,parent);
            child=parent;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

}
