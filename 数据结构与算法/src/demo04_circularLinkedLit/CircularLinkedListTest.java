package demo04_circularLinkedLit;

import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {
    static CircularLinkedList linkedList = new CircularLinkedList();

    @Test
    public void testIterator() {
        linkedList.forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        linkedList.addLast(3);
        linkedList.addLast(4);

        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.forEach(System.out::println);
    }

    @Test
    public void testValue() {
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        linkedList.addLast(3);
        linkedList.addLast(4);

        linkedList.removeByValue(0);
        linkedList.removeByValue(2);
        linkedList.removeByValue(4);
        linkedList.removeByValue(6);
        linkedList.forEach(System.out::println);
    }

    @Test
    public void testRecursion() {
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.loop3(System.out::println, System.out::println);
    }
}
