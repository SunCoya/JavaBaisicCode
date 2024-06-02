package demo10_deque;

import java.util.Iterator;
//使用双向环形链表实现双端列表，为了方便尾巴的删除操作就应该使用双端链表

public class LinkedListDeque<E> implements Deque<E>,Iterable<E>{
    private static class Node<E>{
        E value;
        Node<E> next;
        Node<E> prev;
        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    Node<E> sentinel = new Node<>(null,null,null);
    int capacity;
    int size;
    public LinkedListDeque(int capacity) {
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        this.capacity=capacity;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull())return false;
        Node<E> next = sentinel.next;
        Node<E> node = new Node<>(e,sentinel,next);
        sentinel.next=node;
        next.prev=node;
        size++;
        return true;
    }
    @Override
    public boolean offerLast(E e) {
        if (isFull())return false;
        Node<E> prev = sentinel.prev;
        Node<E> node = new Node<>(e,prev,sentinel);
        sentinel.prev=node;
        prev.next=node;
        size++;
        return true;
    }
    @Override
    public E pollFirst() {
        if (isEmpty())return null;
        Node<E> node = sentinel.next;
        Node<E> next = node.next;
        sentinel.next=next;
        next.prev=sentinel;
        size--;
        return node.value;
    }
    @Override
    public E pollLast() {
        if (isEmpty())return null;
        Node<E> node = sentinel.prev;
        Node<E> prev = node.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
        size--;
        return node.value;
    }
    @Override
    public E PeekFirst() {
        if (isEmpty())return null;
        return sentinel.next.value;
    }
    @Override
    public E PeekLast() {
        if (isEmpty())return null;
        return sentinel.prev.value;
    }


    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public E next() {
                E value= p.value;
                p=p.next;
                return value;
            }
        };
    }
}
