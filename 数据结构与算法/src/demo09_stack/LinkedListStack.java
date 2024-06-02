package demo09_stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    int capacity;
    int size;
    private final Node<E> head = new Node<E>(null,null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if (isFull())return false;
        head.next = new Node<>(value,head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty())return null;
        Node<E> node = head.next;
        head.next=node.next;
        size--;
        return node.value;
    }

    @Override
    public E peek() {
        if (isEmpty())return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next==null;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }
}
