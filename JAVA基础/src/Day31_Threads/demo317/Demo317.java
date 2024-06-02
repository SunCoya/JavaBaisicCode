package Day31_Threads.demo317;
/*
出让线程（礼让线程）
1.出让线程的作用
出让当前线程执行权：能够使得线程抢占更加均匀
2.如何实现礼让线程？
*/
public class Demo317 {
    public static void main(String[] args) {
        MyThread mt0 = new MyThread();
        MyThread mt1 = new MyThread();
        System.out.println("2.使用Thread的静态方法yield每一遍循环都礼让出线程");
        mt0.start();
        mt1.start();
    }
}
