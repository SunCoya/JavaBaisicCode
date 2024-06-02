package Day31_Threads.Demo3115;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread{
    ArrayBlockingQueue<String> queue;
    public Consumer(ArrayBlockingQueue<String> queue) {
         this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                queue.take();
                System.out.println("消费者消费完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
