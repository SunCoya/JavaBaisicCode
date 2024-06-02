package Day31_Threads.demo316;
/*
守护线程(备胎线程)
1.守护线程的特点是？
非守护线程结束的时候，守护线程就没必要存在
2.如何设定线程为守护线程？
在下面的案例中，守护线程一般不会打印到99
*/
public class Demo316 {
    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        System.out.println("2.使用setDaemon方法设置为守护线程");
        mt2.setDaemon(true);
        mt1.start();
        mt2.start();
    }
}
