package Day31_Threads.demo3111;

/*
同步方法
1.同步方法是什么？
把synchronized关键字加到方法上面（写在返回值前面）,和加同步代码块的功能一样

2.同步方法的锁对象是什么？
如果同步方法非静态，锁对象就是this
如果同步方法为静态，就是当前类的字节码文件对象
所以在下面的案例中
由runnable实现的多线程使用的是同一个runnable对象，调用run方法时都是调用的同一个对象中的变量和方法
所以不需要写静态方法，也不需要使用静态来修饰票数
由Thread的子类实现的多线程使用的是不同的thread对象，调用run方法时来到了不同的类当中，需要写静态的同步方法

3.StringBuilder与StringBuffer的区别是什么？
所有方法几乎都是一模一样：StringBuilder是线程不安全的，StringBuffer是线程安全的
（StringBuffer的所有方法几乎都加上了synchronized修饰）
*/
public class Demo3111 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t0.start();
        t1.start();
        t2.start();

/*        MyThread t0 = new MyThread();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t0.start();
        t1.start();
        t2.start();*/
    }
}

