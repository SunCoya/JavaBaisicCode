package demo08_queue;

import java.util.Iterator;

//环形数组队列：对比环形数组，不需要考虑poll时候的数组移动
//对于下标计算：如果有5单位，现在的下标是3，往后移动两位的位置就是（3+2）%5=0，就能回到开头
//（index + step）% length
// 如何判断为空？（头指针尾指针相同），头尾指针都向后移动！向前移动不方便回去
//如何判断尾满？尾指针+1=头指针
public class ArrayQueue<E> implements Queue<E>, Iterable<E> {
    int head = 0;
    int tail = 0;
    E[] array;

    @SuppressWarnings("all")
    public ArrayQueue(int capacity) {
        //根据容量初始化，留一个多的给尾指针
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        //依然是数组长度，非容量
        return (tail + 1) % array.length == head;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        //环形链表不删除已经过去的值
        if (isEmpty())return null;
        return array[head];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p=(p+1)% array.length;
                return value;
            }
        };
    }
}
