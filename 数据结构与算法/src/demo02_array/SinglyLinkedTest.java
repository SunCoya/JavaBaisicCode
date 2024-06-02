package demo02_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedTest {
    @Test
    void test1() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addFirst(1);
        sll.addFirst(2);
        sll.addFirst(3);
        sll.addFirst(4);
        sll.addFirst(5);
        sll.foreach(System.out::print);
    }

    @Test
    void test2() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);
        sll.foreach(System.out::print);
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), sll);
    }

    @Test
    void test3() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(0);
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        System.out.println(sll.get(0));
        System.out.println(sll.get(2));
        System.out.println(sll.get(4));
    }

    @Test
    void test4() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(0, 1);
        sll.insert(1, 2);
        sll.insert(2, 3);
        sll.insert(3, 4);
        sll.insert(0, 0);
        sll.foreach(System.out::print);
    }

    @Test
    void test5() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        System.out.println(sll.removeFirst());
        System.out.println(sll.removeFirst());
        System.out.println(sll.removeFirst());
    }

    @Test
    void test6() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(0);
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);
        System.out.println(sll.remove(0));
        System.out.println(sll.remove(4));
        sll.foreach(System.out::print);
    }


    @Test
    void test7() {
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addFirst(0);
        sll.foreach(System.out::print);
    }


    @Test
    void test8() {
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.insert(0,0);
        sll.insert(4,4);
        sll.foreach(System.out::print);
        assertThrows(IllegalArgumentException.class,()->sll.insert(6,6));
    }

    @Test
    void test9() {
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.insert(0,0);
        sll.insert(4,4);
        System.out.println(sll.remove(0));
        System.out.println(sll.remove(0));
        System.out.println(sll.remove(0));
        System.out.println(sll.remove(0));
        System.out.println(sll.remove(0));
        sll.foreach(System.out::print);
    }
}
