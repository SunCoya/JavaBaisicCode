package demo10_deque;

import java.util.Iterator;
//怎么基于数组实现双端队列呢？offerLast可以，一步一步往后面加，但是offerFirst怎么写呢，把head减一就可以
//head有数据，tail无数据
//在这里用数组应该也要考虑优化空间的方案：之前没有提到，基本数据类型不需要去动，引用数据类型最好删除一下
public class ArrayDeque<E> implements Deque<E>,Iterable<E>{
    int capacity;
    int head,tail;
    E[] arr;
    public ArrayDeque(int capacity) {
        //容量要加一
        this.capacity = capacity+1;
        arr = (E[]) new Object[capacity+1];
    }
    @Override
    public boolean offerFirst(E e) {
        if (isFull())return false;
        head=dec(head);
        arr[head]=e;
        return true;
    }
    @Override
    public boolean offerLast(E e) {
        if (isFull())return false;
        arr[tail]=e;
        tail=inc(tail);
        return true;
    }
    @Override
    public E pollFirst() {
        if (isEmpty())return null;
        E value = arr[head];
        arr[head]=null;
        head=inc(head);
        return value;
    }
    @Override
    public E pollLast() {
        if (isEmpty())return null;
        tail=dec(tail);
        E value=arr[tail];
        arr[tail]=null;
        return value;
    }
    @Override
    public E PeekFirst() {
        if (isEmpty())return null;
        return arr[head];
    }
    @Override
    public E PeekLast() {
        if (isEmpty())return null;
        return arr[dec(tail)];
    }
    @Override
    public boolean isEmpty() {
        return head==tail;
    }
    @Override
    public boolean isFull() {
        return (tail-head==capacity-1)||(tail-head==-1);
    }
    int inc(int i){return (i+1)%capacity;}
    //原来是i-1>0，后来发现i=1就不行，要等于
    int dec(int i){return i>=1?i-1:capacity-1;}
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p=head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public E next() {
                E value = arr[p];
                p=inc(p);
                return value;
            }
        };
    }
}
