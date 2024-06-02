package Day31_Threads.demo312;
/*
多线程的第二种实现方式:实现Runnable接口：通过Thread对象--传入自己写的类的对象--来开始线程
1.如何创建runnable的实现类？表示什么？
2.如何获取当前的线程的对象？
3.如何使用runnable对象开始线程？
*/
public class Demo312 {
    public static void main(String[] args) {
        System.out.println("1.创建类实现Runnable接口，实现run方法，表示线程将要执行的任务");
        System.out.println("2.使用Thread的静态方法currentThread（）方法获取当前线程对象");
        MyRunnable myRunnable = new MyRunnable();
        System.out.println("3.在Thread类的构造方法中同一个传入runnable的实现类对象，再start thread对象开启线程");
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.setName("线程1：");
        thread2.setName("线程2：");
        thread1.start();
        thread2.start();
    }
}
