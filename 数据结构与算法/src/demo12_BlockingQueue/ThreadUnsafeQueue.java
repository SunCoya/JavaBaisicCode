package demo12_BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   目前队列存在问题：线程不安全
 *   队列为空怎么办？要拿到东西怎么办？不断循环？生产者需要唤醒消费者
 *   队列为满怎么办？不断噻？消费者需要唤醒生产者
 */
public class ThreadUnsafeQueue {
    String[] array = new String[10];
    int tail = 0;
    int size=0;
    ReentrantLock reentrantLock = new ReentrantLock();
    //条件变量对象，是一个集合，存储多个可以阻塞的线程
    Condition tailWaits = reentrantLock.newCondition();

    void offer(String s) throws InterruptedException {
        //断点类型可以选择Thread，不同的线程执行到这行代码会停下来，左下角切换不同线程
        //在java中可以使用两种锁：synchronized（功能少）和ReentrantLock（可重入锁，功能多）
        //reentrantLock.lock();//加锁不能打断
        reentrantLock.lockInterruptibly();//加锁，可以在阻塞的过程中随时打断
        try {
            while (isFull()){
                //队列满了应该做：offer线程阻塞，添加元素的代码不执行，当取走元素的时候应该唤醒
                //这里如果有一个线程被唤醒的时候另一个线程先拿到锁（虚假唤醒）再让这个线程走，会从if下面直接走，而不是判断了，这里把if改成while
                tailWaits.await();//当前线程加入阻塞集合中，await会主动释放锁
            }
            array[tail] = s;
            //tail加到无效索引，tail变成0
            tail=(tail+1)%(array.length);
            size++;
        } finally {
            reentrantLock.unlock();//解锁
        }
    }
    boolean isFull(){
        return size>=array.length;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadUnsafeQueue queue = new ThreadUnsafeQueue();
        for (int i = 0; i < 10; i++) {
            queue.offer("e"+i);
        }

        //在上面的offer方法中可能就导致同一个位置赋值两次
        new Thread(()-> {
            try {
                queue.offer("e10");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1").start();
        new Thread(()-> {
            try {
                //唤醒线程，signal使用也需要加锁解锁，不能直接调用
                queue.reentrantLock.lockInterruptibly();
                queue.tailWaits.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                //这里的锁解开之后才唤醒t1线程
                queue.reentrantLock.unlock();
            }
        },"t2").start();
    }
}
