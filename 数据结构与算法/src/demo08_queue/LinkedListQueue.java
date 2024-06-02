package demo08_queue;
import java.util.Iterator;
//单向环链表队列
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {
    private static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    Node<E> head;
    Node<E> tail;
    int size;//当前节点数
    int capacity = Integer.MAX_VALUE;
    {
        head = new Node<E>(null,null);
        head.next=head;
        tail=head;
    }
    //自己能指定容量
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }
    public LinkedListQueue() {}
    //tail在有元素的情况下代表最后一个元素
    @Override
    public boolean offer(E value) {
        if (isFull())return false;
        tail.next = new Node<E>(value,head);
        tail=tail.next;
        size++;
        return true;
    }
    @Override
    public E poll() {
        if (isEmpty())return null;
        E value = head.next.value;
        if (head.next==tail)tail=head;
        head.next=head.next.next;
        size--;
        return value;
    }
    @Override
    public E peek() {
        return head.next.value;
    }
    @Override
    public boolean isEmpty() {
        return head==tail;
    }
    //检查队列是否已满
    @Override
    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=head;
            }
            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }
}
