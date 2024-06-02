package Day31_Threads.demo3112;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
锁对象Lock
为了更加清晰的表示如何加锁与如何释放锁，提供了新的锁对象Lock
1.Lock对象在使用的时候有什么特点？
在Lock当中需要手动上锁与手动释放锁
2.使用什么类去实现锁对象呢？
Lock为接口，使用其对象需要用到ReentrantLock(可重入的锁)来实例化
3.如何上锁，如何关锁？可以用什么方法使得关锁这个操作到最后一定会执行？
使用lock方法上锁，使用unlock方法关锁，也是和synchronized包裹的范围一样
有时候退出循环操作中可能会忘记释放锁。使用try-catch-finally去释放锁：最为稳妥
*/
public class MyThread extends Thread {
    static int ticket = 0;
    //创建对象:用同一把锁，需要加静态
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //上锁
            lock.lock();
            try {
                //有时候退出循环操作中可能会忘记释放锁，这里由于使用了finally，这里不需要释放锁
                if (ticket >= 100)break;
                ticket++;
                System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
            } catch (Exception ignored) {
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
