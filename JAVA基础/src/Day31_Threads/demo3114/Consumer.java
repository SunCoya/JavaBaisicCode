package Day31_Threads.demo3114;
/*
等待唤醒机制
线程中的等待者和唤醒者（等待唤醒机制）：可以让线程轮流执行
其中一条线程叫做生产者，负责生产数据，另一条线程叫做消费者，负责消费数据
1.线程的运行由什么决定？
产品的有无决定是哪一条线程运行
2.消费者抢到CPU执行权会做什么？
如果是消费者抢到CPU执行权， 没有产品，只能等（wait）生产者生产
如果有产品，就消费-唤醒厨师生产。
3.生产者抢到CPU会做什么？
如果是生产者抢到CPU执行权，有产品，只能等着（wait）消费者消费
没有食物就制作-唤醒消费者
4.如何唤醒单个线程与多个线程
notify是随机唤醒单个线程
notifyAll是唤醒所有
*/
public class Consumer extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Product.myLock){
                if (Product.count == 0)break;
            /*
                1.什么是wait方法？什么时候能够停止wait？
                wait是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，当然自己停止抢占CPU，
                以便其他正在等待此锁的线程可以得到同步锁并运行，只有其他线程调用了notify方法或者notifyAll
                 （notify并不释放锁，只是告诉调用过wait方法的线程可以去参与获得锁的竞争了
                但不是马上得到锁，因为锁还在别人手里，别人还没释放），
                调用wait方法的一个或多个线程就会解除wait状态，重新参与竞争对象锁，
                程序如果可以再次得到锁，就可以继续向下运行。
                2.如何使用wait方法与notify方法？
                不能通过线程对象去调用，需要通过锁对象（同一个）去调用
            */
                if (Product.flag==0) {
                    try {
                        //等待的时候要用锁对象去wait()
                        Product.myLock.wait();//让当前线程和锁进行绑定
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Product.flag=0;
                    Product.count--;
                    System.out.println("消费者消费完毕，还能再消费"+Product.count+"个");
                    //唤醒这把锁绑定的所有线程
                    Product.myLock.notifyAll();
                }
            }
        }
    }
}
