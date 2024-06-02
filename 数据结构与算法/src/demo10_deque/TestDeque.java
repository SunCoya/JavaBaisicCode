package demo10_deque;

import org.junit.jupiter.api.Test;

public class TestDeque {
    @Test
    public void testLinkedListDequeOffer(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println("测试越界");
        System.out.println(deque.offerLast(6));
        deque.forEach(System.out::println);
    }

    @Test
    public void testLinkedListDequePoll(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.isEmpty());
    }

    @Test
    public void testArrayDequeOffer(){
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        System.out.println("测试越界");
        System.out.println(deque.offerLast(6));
        deque.forEach(System.out::println);
    }

    @Test
    public void testArrayDequePoll(){
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.isEmpty());
    }
}
