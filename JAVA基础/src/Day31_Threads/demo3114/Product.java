package Day31_Threads.demo3114;

public class Product {
    //控制生产者和消费者的执行：如果使用boolean：只能控制两条线程轮流执行
    public static int flag = 0;
    //总运行次数
    public static int count = 10;
    //锁
    public static final Object myLock = new Object();
}
