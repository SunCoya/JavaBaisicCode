package demo12_BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//但锁不可以同时增删，这里用双锁，但是唤醒要操作一下
//好了，用了双锁，防止了死锁，结果呢，还是要等到主要方法执行完再执行下一个方法。。。接下来就要减少唤醒的次数，让其在最必要的时候加锁
//在生产者这边只做一次唤醒，剩下来的交给消费者（级联通知）
public class BlockingQueue2<E> implements BlockingQueue<E> {
    private final E[] array;
    private  int head;
    private  int tail;
    //原子整数类来保护size的线程安全
    private AtomicInteger size = new AtomicInteger();
    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }
    private ReentrantLock tailLock= new ReentrantLock();
    private ReentrantLock headLock= new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();
    private Condition headWaits = headLock.newCondition();
    public boolean isEmpty(){return size.get()==0;}
    public boolean isFull(){return size.get()==array.length;}
    @Override
    public E poll() throws InterruptedException {
        int count;//取走前的元素个数
        E value = null;
        headLock.lockInterruptibly();
        try {
            while (isEmpty())headWaits.await();
            //这个不能放外面，要放在醒来后的代码中
            value = array[head];
            array[head]=null;
            head=(head+1)%(array.length);
            //size有三步：读-计算-写 ，如果两边都读（5，5），一遍减去然后写（5，4），另一边加然后写（6，4），最后结果就是6，而不是不变的5
            count = size.getAndDecrement();
            //不能在这里唤醒生产者了，会死锁（因为在这里要用到tail锁），避免嵌套！
            //在这里唤醒别的消费者
            if (count>1)headWaits.signal();
        }finally {
            headLock.unlock();
        }
        //什么情况唤醒生产者呢？仓库刚刚减少
        if (count <= array.length) {
            tailLock.lock();
            try{
                //直接在这里唤醒会报错：使用condition对象必须要配对使用
                tailWaits.signal();
            }finally {
                tailLock.unlock();
            }
        }
        return value;
    }
    @Override
    public void offer(E e) throws InterruptedException {
        int count;//添加前的元素个数
        tailLock.lockInterruptibly();
        try {
            while (isFull())tailWaits.await();
            array[tail]=e;
            tail=(tail+1)%(array.length);
            count=size.getAndIncrement();//先获取再自增
            if (count+1<array.length)tailWaits.signal();//还有空位，唤醒工友
        }finally {
            tailLock.unlock();
        }
        //只在刚刚有产品的时候再去叫消费者
        if (count==0){
            headLock.lock();
            try {
                headWaits.signal();
            }finally {
                headLock.unlock();
            }
        }
    }
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        int count;//添加前的元素个数
        tailLock.lockInterruptibly();
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()){
                if (nanos<=0)return false;
                nanos = tailWaits.awaitNanos(nanos);
            }
            array[tail]=e;
            tail=(tail+1)%(array.length);
            count=size.getAndIncrement();
            if (count+1<array.length)tailWaits.signal();
        }finally {
            tailLock.unlock();
        }
        if (count==0){
            headLock.lock();
            try {
                headWaits.signal();
            }finally {
                headLock.unlock();
            }
        }
        return true;
    }
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
