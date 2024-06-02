package Day32_ThreadsPractice_ThreadPool.demo324;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池：用来存放线程，避免多次重复创建线程
提交任务时，线程池会创建新的线程对象，任务执行完毕之后，线程归还给池子
1.下次再创建任务的时候还需要创建新的线程吗？
不需要再创建新的线程，复用已经有的线程即可
2.如果提交任务的时候池子里面没有空闲线程，就无法创建新的线程，任务会如何进行？
任务就会排队等待

3.线程池创建过程？
1.创建线程池
2.提交任务
3.所有任务执行完毕时，关闭线程池（实际开发中线程池一般不会关闭）

4.创建线程池的快速方法？
使用Executors(执行人)的静态方法创建线程池

5.如何创建无上限的线程池？
6.如何提交任务？
7.如何停止线程？
8.如何创建有上限的线程池？
*/
public class Demo324 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("5.使用Executors的newCachedThread方法获取线程池对象(cached-缓存),无上限");
        ExecutorService pool = Executors.newCachedThreadPool();

        System.out.println("6.使用线程池的submit方法提交任务,这里只能提交runnable对象，这里的输出的线程池名字与线程名字编号都是从1开始的");

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        Thread.sleep(1000);
        //在这里睡了一小会之后使用的还是原来的线程：不会创建新的线程（用线程一还是线程二是随机的）
        pool.submit(new MyRunnable());

        Thread.sleep(1000);
        System.out.println("7.使用线程池的shutdown方法停止线程");
        pool.shutdown();

        Thread.sleep(1000);

        System.out.println("8.使用Executors的newFixedThreadPool方法创建有上限的线程池");
        pool = Executors.newFixedThreadPool(1);
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.shutdown();
    }
}
