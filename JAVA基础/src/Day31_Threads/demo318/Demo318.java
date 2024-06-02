package Day31_Threads.demo318;
/*
插入线程（插队线程）
1.如何插入线程？
2.插入线程有什么作用？
*/
public class Demo318 {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        System.out.println("1.使用Thread对象的join方法插入线程");
        System.out.println("2.表示把mt这个线程插入到当前线程（在这里是main线程）线程之前，有这行与没这行输出结果不一样");
        System.out.println("加入下面这一行，会强行停止main进程，不加的话则是两个进程同时进行");
        mt.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("main："+i);
        }
    }
}
