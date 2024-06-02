package Day31_Threads.Demo3115;

import java.util.concurrent.ArrayBlockingQueue;

/*
利用阻塞队列实现等待唤醒机制(不使用锁)
1.阻塞的含义？
put时当队列满的时候不能再加入元素
take第一个数据取不到会等待
2.阻塞队列实现了哪接口？
Iterable（可迭代器遍历）与Collection（单列集合）接口
实现了Queue接口，实现了BlockingQueue接口（阻塞队列）
3.阻塞队列的实现类有哪些？分别有什么特点？
ArrayBlockingQueue（有界）与LinkedBlockingQueue（近乎无界-21亿）
*/
public class Demo3115 {
    public static void main(String[] args) {
        //创建阻塞队列的对象:在其他两个类里面也定义一个这样的变量，通过构造方法获取这个对象，这样能够让两个类使用同一个对象。
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(1);
        Consumer consumer = new Consumer(abq);
        Producer producer = new Producer(abq);
        consumer.start();
        producer.start();
    }
}
