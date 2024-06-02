package Day32_ThreadsPractice_ThreadPool.demo325;

import Day32_ThreadsPractice_ThreadPool.demo324.MyRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
自定义线程池 参数如下：
1.核心线程数量（核心员工）
2.线程中最大线程数量（包括临时员工）
3.4.临时线程空闲时间与单位（临时员工存活时间）
5.阻塞队列
6.创建线程的方式
7.要执行任务过多的解决方案

创建临时线程的时机是在什么时候？
阻塞队列满了之后才能创建，不是核心线程被占满了才创建，创建临时线程处理队伍之外的任务！
*/
public class Demo325 {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3),//不想指定长度就写LinkedArrayBlockingQueue
                Executors.defaultThreadFactory(),//创建线程工厂，底层是创建Thread线程
                new ThreadPoolExecutor.AbortPolicy()//静态内部类（依赖于线程池，单独存在无意义），任务的默认拒绝策略：抛错
        );
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.submit(new MyRunnable());
        tpe.shutdown();
    }
}
