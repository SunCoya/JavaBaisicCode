package Day31_Threads.demo3113;
/*
死锁案例
1.死锁可能出现的情况？
在程序当中出现了锁的嵌套：外面一个锁，里面一个锁
想要避免死锁就需要注意多线程中锁嵌套的情况
在这个案例中，使用了两个线程，执行两端不同的代码：但是使用的是相同的锁对象
在线程一拿到锁A，线程二拿到锁B的情况下，两个线程由于得不到锁进行不下去
*/
public class Demo3113 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
