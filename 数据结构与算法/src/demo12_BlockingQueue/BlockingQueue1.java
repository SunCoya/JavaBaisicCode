package demo12_BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<E> implements BlockingQueue<E>{
    private final E[] array;
    private  int head;
    private  int tail;
    private int size;

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    //新增锁
    private ReentrantLock lock= new ReentrantLock();
    //出队空，头等
    private Condition headWaits = lock.newCondition();
    //入队，尾巴等
    private Condition tailWaits = lock.newCondition();
    public boolean isEmpty(){return size==0;}
    public boolean isFull(){return size==array.length;}
    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull())tailWaits.await();
            array[tail]=e;
            tail=(tail+1)%(array.length);
            size++;
            headWaits.signal();
        }finally {
            lock.unlock();
        }
    }
    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty())headWaits.await();
            E value = array[head];
            array[head]=null;
            head=(head+1)%(array.length);
            size--;
            tailWaits.signal();
            return value;//finally依然执行
        }finally {
            lock.unlock();
        }

    }

    //在原有的offer方法基础上多出一个选择：设置超时时间，超过时间返回false
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {//毫秒
        lock.lockInterruptibly();
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            //有时间上限的等待
            while (isFull()){
                //等待完毕，返回false
                if (nanos<=0)return false;
                //等待纳秒，返回值为剩下的时间
                nanos = tailWaits.awaitNanos(nanos);
            }
            array[tail]=e;
            tail=(tail+1)%(array.length);
            size++;
            headWaits.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
