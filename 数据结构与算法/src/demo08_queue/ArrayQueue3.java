package demo08_queue;

import java.util.Iterator;

//要求数组长度为2n
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    int head = 0;
    int tail = 0;
    E[] array;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        //和原数字减一做按位与，为零就是2的n次方
        if ((capacity&capacity-1)!=0){
            //求与数字最接近的 2 的 N 次方：有更加底层的方法，原理就是用或运算把最高位以后的数字全部变成1，再加一变成2N数字
            int n = (int) (Math.log10(capacity) / Math.log10(2))+1;
            //得到2的n次方
            capacity=1<<n;
        }
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        //越界不影响运算结果，只要这个结果不越界就可以
        return head - tail == array.length;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        //按位与，array长度假定2n次方，相当于求余，这里可以不加括号
        //所以，就算tail在这里越界了，这个地方也不会变成负数的数组下标
        array[tail&(array.length-1)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = array[head&(array.length-1)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head&(array.length-1)];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p&(array.length-1)];
                p++;
                return value;
            }
        };
    }
}
