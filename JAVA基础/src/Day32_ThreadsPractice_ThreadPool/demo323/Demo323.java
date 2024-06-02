package Day32_ThreadsPractice_ThreadPool.demo323;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//案例：两个抽奖池抽奖：获取线程运行的结果
public class Demo323 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       MyCallable myCallable = new MyCallable();
        System.out.println("需要注意的点：这里要创建两个多线程运行结果的管理对象");
       FutureTask<Integer> futureTask0 = new FutureTask<>(myCallable);
       FutureTask<Integer> futureTask1= new FutureTask<>(myCallable);
       Thread t0 = new Thread(futureTask0);
       Thread t1 = new Thread(futureTask1);
       t0.start();
       t1.start();
       Integer i0 = futureTask0.get();
       Integer i1 = futureTask1.get();
       System.out.println("在这个抽奖过程中");
       if (i1==null||i0>i1){
           System.out.print(t0.getName()+"抽到了最大奖项，该奖金金额为："+i0+"元");
       }else {
           System.out.print(t1.getName()+"抽到了最大奖项，该奖金金额为："+i1+"元");
       }
    }
}
