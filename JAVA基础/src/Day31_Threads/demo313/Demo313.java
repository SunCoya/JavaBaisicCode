package Day31_Threads.demo313;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
多线程第三种实现方式：利用Callable接口(返回多线程与运行结果)与Future（管理多线程运行结果）接口方式实现
1.第三种方式相较于前两种方式有什么特点？
在继承Thread类中的run方法不能返回结果
在实现Runnable的类中的run方法也没有返回值
如果需要返回值可以使用第三种实现方式：可以获取到多线程运行的结果

2.继承Thread类的优缺点
编程简单，可以直接使用这个类中的方法，但是不能继承其他类，扩展性差

3.如何如何使用Callable接口与Future接口实现多线程？
*/
public class Demo313 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("（1）编写实现类，实现call方法，规定返回值");
        System.out.println("（2）创建实现类的对象myCallable");
        MyCallable mc = new MyCallable();
        System.out.println("（3）创建FutureTask对象（为Future实现类）来管理多线程执行的结果");
        FutureTask<Integer> ft = new FutureTask<>(mc);
        System.out.println("（4）创建线程，传入FutureTask对象并执行");
        Thread t1= new Thread(ft);
        t1.start();
        System.out.print("（5）使用ft对象的get方法获取线程的结果：");
        System.out.println(ft.get());
    }
}
