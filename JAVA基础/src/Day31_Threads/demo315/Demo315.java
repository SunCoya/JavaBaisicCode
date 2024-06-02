package Day31_Threads.demo315;
/*
线程优先级
1.线程调度分为哪两种？
分为抢占式调度（随机执行）与非抢占式调度（轮流执行）
2.Java中采用的是哪种线程调度？
Java中采用的是抢占式调度，优先级越高，这条线程抢到CPU的概率越大
3.如何获得与设置线程的优先级？
*/
public class Demo315 {
    public static void main(String[] args) {
        MyThread mt0 = new MyThread();
        MyThread mt1 = new MyThread();
        System.out.println("1.使用getPriority（）方法获得线程优先级");
        System.out.print(mt0.getPriority()+" ");
        System.out.println(mt1.getPriority());
        System.out.println("Main线程优先级："+Thread.currentThread().getPriority());
        System.out.println("2.使用get与setPriority设置优先级，最小是1，最大是10");
        mt0.setPriority(10);
        mt1.setPriority(1);
        mt0.start();
        mt1.start();
    }
}
