package Day31_Threads.demo3114;

public class Demo3114 {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        consumer.start();
        producer.start();
    }
}
