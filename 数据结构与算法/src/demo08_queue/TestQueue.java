package demo08_queue;

import org.junit.jupiter.api.Test;

public class TestQueue {
    @Test
    public void testOffer(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.forEach(System.out::println);
    }

    @Test
    public void testPeek(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        System.out.println(queue.peek());
        queue.offer(1);
        System.out.println(queue.peek());
        queue.offer(2);
        System.out.println(queue.peek());
    }

    @Test
    public void testPoll(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
        System.out.println(queue.poll());
    }

    @Test
    public void testSize()
    {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(2);
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(1));
        queue.forEach(System.out::println);
    }

    @Test
    public void testArrayQueue(){
        ArrayQueue2<Integer> arrayQueue = new ArrayQueue2<>(5);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        arrayQueue.forEach(System.out::println);
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.offer(5));
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.offer(6));
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.poll());
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        arrayQueue.offer(5);
    }
}
