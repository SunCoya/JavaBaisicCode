package demo08_queue;

import java.util.Iterator;

//第二种环形数组：使用size表示大小，不用指针判断数组空满
//第三种方法：让head与tail不断增加，不用%运算，C可以用无符号解决，这里不学
//除数是2的n次方，在二进制中找商和余更加容易
public class ArrayQueue2<E> implements Queue<E>, Iterable<E> {
    int head = 0;
    int tail = 0;
    E[] array;
    int size;

    @SuppressWarnings("all")
    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = array[head];
        head = (head + 1) % array.length;
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
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
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
