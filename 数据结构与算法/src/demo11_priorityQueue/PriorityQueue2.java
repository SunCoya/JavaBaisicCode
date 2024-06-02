package demo11_priorityQueue;

//优先级队列：有序数组实现，在数组中排序好优先级，出队直接出，与上一个相反
public class PriorityQueue2<E extends Priority>implements Queue<E>{
    Priority[] arr;
    int size=0;
    int capacity;
    public PriorityQueue2(int capacity) {
        this.capacity=capacity+1;
        arr = new Priority[capacity+1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        int index = size-1;
        for (;index>=0;index--)if (value.priority()>=arr[index].priority())break;
        if (index!=size-1)System.arraycopy(arr,index+1,arr,index+2,size-index-1);
        arr[index+1]=value;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = (E) arr[size-1];
        arr[--size]=null;//help GC
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return (E) arr[size-1];
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean isFull() {
        return size==capacity-1;
    }
}
