package demo03_doublyLinkedList;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListSentinelTest {
    static DoublyLinkedListSentinel doublyLinkedList = new DoublyLinkedListSentinel();

    @Test
    public void testInsert(){
        doublyLinkedList.insert(0,4);
        doublyLinkedList.insert(0,3);
        doublyLinkedList.insert(0,2);
        doublyLinkedList.insert(0,1);
        doublyLinkedList.insert(0,0);
        doublyLinkedList.forEach(System.out::println);
    }

    @Test
    public void testAddFirst(){
        doublyLinkedList.addFirst(0);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.forEach(System.out::println);
    }

    @Test
    public void testAddAndRemoveLast(){
        doublyLinkedList.addLast(0);
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.forEach(System.out::println);
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
    }

    @Test
    public void testRemove(){
        doublyLinkedList.addFirst(0);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.forEach(System.out::print);
        System.out.println();
        doublyLinkedList.remove(3);
        doublyLinkedList.remove(0);
        doublyLinkedList.forEach(System.out::print);
    }
}
