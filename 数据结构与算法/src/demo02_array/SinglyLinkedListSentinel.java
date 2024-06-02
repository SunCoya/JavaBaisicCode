package demo02_array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 带哨兵单向链表
 * 带哨兵就不要判断头,last是不是空
 * getNode方法就可以从-1开始
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    //初始化哨兵
    private Node head = new Node(0, null);
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    void addFirst(int i) {
        head.next = new Node(i, head.next);
    }
    Node findLast() {
        Node p = head;
        while (p.next != null) p = p.next;
        return p;
    }
    void addLast(int i) {
        findLast().next = new Node(i, null);
    }
    Node getNode(int index) {
        int i = -1;
        Node p = head;
        while (p != null && i != index) {
            p = p.next;
            i++;
        }
        if (p == null) throw new IllegalArgumentException("index：" + index + "不合法");
        return p;
    }

    int get(int index) {
        Node node = getNode(index);
        return node.value;
    }

    void insert(int index, int value) {
        Node node = getNode(index - 1);
        node.next = new Node(value, node.next);
    }

    int removeFirst() {
        return remove(0);
    }

    int remove(int index) {
        Node prev = getNode(index - 1);
        Node removed = getNode(index);
        prev.next = removed.next;
        return removed.value;
    }


    //两种遍历方法只要把开始计算的节点改一改
    void foreach(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int result = p.value;
                p = p.next;
                return result;
            }
        };
    }
}
