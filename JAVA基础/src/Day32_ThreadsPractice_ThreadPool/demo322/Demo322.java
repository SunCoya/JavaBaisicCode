package Day32_ThreadsPractice_ThreadPool.demo322;
//案例：两个抽奖池抽奖
public class Demo322 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t0 = new MyThread();
        t1.start();
        t0.start();
        System.out.println("到这一行就开启了三条线程");
        System.out.println("main方法是运行在main线程中的栈，线程12开启的时候在内存中会多出两个栈：线程一的方法栈和线程2的方法栈");
    }
}
