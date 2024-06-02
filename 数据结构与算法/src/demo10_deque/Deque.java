package demo10_deque;

public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E PeekFirst();
    E PeekLast();
    boolean isEmpty();
    boolean isFull();
}
