package demo11_priorityQueue;

//优先级队列，需要实现优先级的接口
public class PriorityQueue<E extends Priority>implements Queue<E>{
    Priority[] arr;
    //size代表尾部指针
    int size=0;
    int capacity;

    public PriorityQueue(int capacity) {
        this.capacity=capacity+1;
        arr = new Priority[capacity+1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        arr[size++]=value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        int max = findMax();
        E value = (E) arr[max];
        //多放一个size，刚好是空
        if (max<size-1)System.arraycopy(arr,max+1,arr,max,size-max);
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return (E) arr[findMax()];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity-1;
    }
    private int findMax(){
        int m=0;
        //难怪要实现这个接口哈哈哈
        for (int i = 0; i < size; i++) if (arr[i].priority()>arr[m].priority())m=i;
        return m;
    }
}
