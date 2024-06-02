package demo02_array;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 自定义单向链表
 * 1.头节点,不需要真的初始化，第一个加入的元素即可作为head
 * 2.head为空或非空都能使用同一行代码，不需要分情况写了
 * 3.链表里面也能加迭代器
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head;

    private static class Node {
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    void addFirst(int i) {
        head = new Node(i, head);
    }

    //链表尾部增加节点：分成找到最后一个节点与添加节点
    Node findLast() {
        if (head == null) return null;
        else {
            Node p = head;
            while (p.next != null) p = p.next;
            return p;
        }
    }

    void addLast(int i) {
        Node last = findLast();
        if (last == null) addFirst(i);
        else last.next = new Node(i, null);
    }

    //获得某下标的值，分解为获得下标与根据下标获取值
    Node getNode(int index) {
        int i = 0;
        Node p = head;
        while (p != null && i != index) {
            i++;
            p = p.next;
        }
        if (p == null) throw new IllegalArgumentException("index：" + index + "不合法");
        return p;
    }

    int get(int index) {
        Node node = getNode(index);
        return node.value;
    }

    void insert(int index, int value) {
        if (index == 0) addFirst(value);
        else {
            Node node = getNode(index - 1);
            node.next = new Node(value, node.next);
        }
    }

    int removeFirst() {
        if (head == null) throw new NullPointerException("已经删完啦");
        int value = head.value;
        head = head.next;
        return value;
    }

    int remove(int index) {
        if (index == 0) return removeFirst();
        Node prev = getNode(index - 1);
        Node removed = getNode(index);//检测需要操作的数据是否为空
        prev.next = removed.next;
        return removed.value;
    }

    void foreach(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head;

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
