package Day31_Threads.Demo3115;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread{
    //也可以使用构造方法传入一个对象来初始化变量，也能写静态代码块：只能在一个类里面写，保证是同一个对象
    ArrayBlockingQueue<String> queue;
    public Producer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        //生产者只需要put一个产品就可以了
        while (true){
            try {
                //在put方法中会创建锁，如果队列装满了，就wait，没有装满就放数据
                queue.put("产品");
                //这里由于输出语句是写在锁之外，所以输出可能会有连续
                System.out.println("生产了一个产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
