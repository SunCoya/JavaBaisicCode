package Day31_Threads.demo3110;
public class Demo3110 {
    public static void main(String[] args) {
        MyThread t0 = new MyThread();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t0.start();
        t1.start();
        t2.start();
    }
}
