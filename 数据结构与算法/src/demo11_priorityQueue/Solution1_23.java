package demo11_priorityQueue;

import java.util.PriorityQueue;

//合并有序链表，之前是用的二分治理+合并两个有序链表做的
//PriorityQueue是java的堆
public class Solution1_23 {
    //使用java的优先级队列，慢一点
    public ListNode mergeKLists2(ListNode[] lists) {
        //小顶堆不用写，大顶堆要写，a2-a1
        if (lists.length==0)return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length,(o1, o2) -> o1.val-o2.val);
        for (ListNode list : lists)if (list!=null)minHeap.offer(list);
        ListNode sentinel = new ListNode(0,null);
        ListNode p = sentinel;
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            p.next = node;
            p=node;
            if (node.next!=null)minHeap.offer(node.next);
        }
        return sentinel.next;
    }

    //使用堆，把每个链表中的第一个放进去，出来一个放一个
    //能把所有的先放进去吗？可，但是占用空间
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap minHeap = new MinHeap(lists.length);
        ListNode sentinel = new ListNode(0,null);
        for (ListNode list : lists) minHeap.offer(list);
        ListNode p = sentinel;
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            p.next = node;
            p=node;
            minHeap.offer(node.next);
        }
        return sentinel.next;
    }


    //小顶堆，最多500个数组
    static class MinHeap{
        ListNode[] array;
        int size;
        int capacity;
        public MinHeap(int capacity) {
            size=0;
            this.capacity = capacity+1;
            array=new ListNode[this.capacity];
        }
        boolean isEmpty(){
            return size==0;
        }
        boolean isFull(){
            return size==capacity-1;
        }
        private void swap(int i,int j){
            ListNode t = array[i];
            array[i]=array[j];
            array[j]=t;
        }
        ListNode poll(){
            if (isEmpty())return null;
            ListNode node = array[0];
            array[0]=array[size-1];
            array[--size] = null;
            int parent = 0;
            while (true){
                int left = parent*2+1;
                int right = left+1;
                int min = parent;
                //这里不能比较自己记录的smallValue，必须要变化，也不能直接是min
                if (left<size&&array[left].val<array[min].val)min=left;
                if (right<size&&array[right].val<array[min].val)min=right;
                if (min==parent)break;
                swap(min,parent);
                parent=min;
            }
            return node;
        }
        void offer(ListNode node){
            if (node==null)return;
            if (isFull())return;
            int child = size++;
            while(child!=0){
                int parent = (child-1)/2;
                //这里要写node！
                if (array[parent].val<=node.val)break;
                array[child]=array[parent];
                child=parent;
            }
            array[child] = node;
        }
    }
}
