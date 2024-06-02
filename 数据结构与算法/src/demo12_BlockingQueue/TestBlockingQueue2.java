package demo12_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockingQueue2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);//java阻塞队列
        BlockingQueue2<String> queue = new BlockingQueue2<>(3);
        new Thread(()->{
            try{
                String poll =queue.poll();
                System.out.println(poll+" t1");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        },"poll1").start();
        new Thread(()->{
            try{
                String poll =queue.poll();
                System.out.println(poll+" t2");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        },"poll2").start();

        new Thread(()->{
            try {
                queue.offer("元素");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        },"offer").start();

    }
}
