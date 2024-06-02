package Day31_Threads.demo314;
/*
多线程中的常用方法
GetSetName方法
1.使用getName方法获取默认名字的特点？
2.如何在创建线程对象的时候设定名字？
3.如何获取到当前线程对象时，获取的对象由什么决定？
4. 如何使线程休眠（静态）？
*/
public class Demo314 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.使用getName方法获取默认名字的特点：在底层每调用一次构造方法，静态变量就会++，根据这个静态变量起名");
        System.out.print(new MyThread().getName()+" ");
        System.out.print(new MyThread().getName()+" ");
        System.out.println(new MyThread().getName());

        System.out.println("2.在创建线程时传入字符串即可设定名字。");
        System.out.print("由于继承不能继承构造方法：需要重写构方法造：传入字符串设置名字：");
        System.out.println(new MyThread("线程名字").getName());

        System.out.println("3.哪条线程执行到这个方法，获取到的就是那条线程的对象:JVM启动之后会自动启动多条线程");
        System.out.println("其中main线程的作用就是调用main方法并执行里面的代码：");
        System.out.print(Thread.currentThread().getName());

        System.out.println("4.使用Thread的静态方法sleep设置当前线程线程的睡眠时间");
        Thread.sleep(2000);
        System.out.println("睡眠结束");
        new MyThread().start();
    }
}

