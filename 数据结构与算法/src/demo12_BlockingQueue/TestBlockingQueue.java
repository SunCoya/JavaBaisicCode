package demo12_BlockingQueue;

public class TestBlockingQueue {
    //这里不能用Test
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);
        Thread t1 = new Thread(()->{
            try{
                long begin = System.currentTimeMillis();
                queue.offer("任务一");
                System.out.println(queue);
                queue.offer("任务二");
                System.out.println(queue);
                queue.offer("任务三");
                System.out.println(queue);
                queue.offer("任务四",4000);
                System.out.println(queue);
                System.out.println("所用时间（ms）："+(System.currentTimeMillis()-begin));
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        },"生产者");
        t1.start();
        //等待两秒取走一个元素
        Thread.sleep(2000);
        queue.poll();
    }
}
