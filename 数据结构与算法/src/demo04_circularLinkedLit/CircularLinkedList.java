package demo04_circularLinkedLit;

import java.util.Iterator;
import java.util.function.Consumer;

//双向环形链表
public class CircularLinkedList implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public Integer next() {
                int result = p.value;
                p = p.next;
                return result;
            }
        };
    }

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    final private Node head;

    public CircularLinkedList() {
        head = new Node(0, null, null);
        head.prev = head;
        head.next = head;
    }

    public void addFirst(int value) {
        Node nodeNext = head.next;
        Node node = new Node(value, head, nodeNext);
        head.next = node;
        nodeNext.prev = node;
    }

    public void addLast(int value) {
        Node nodePre = head.prev;
        Node node = new Node(value, nodePre, head);
        head.prev = node;
        nodePre.next = node;
    }

    public void removeFirst() {
        Node node = head.next;
        if (node == head) throw new NullPointerException("已经删完啦！");
        Node nodeNext = node.next;
        nodeNext.prev = head;
        head.next = nodeNext;
    }

    public void removeLast() {
        Node node = head.prev;
        if (node == head) throw new NullPointerException("已经删完啦！");
        Node nodePre = node.prev;
        nodePre.next = head;
        head.prev = nodePre;
    }

    public void removeByValue(int value) {
        Node p = head.next;
        while (head != p) {
            if (p.value == value) {
                Node nodePre = p.prev;
                Node nodeNext = p.next;
                nodePre.next = nodeNext;
                nodeNext.prev = nodePre;
                return;
            }
            p=p.next;
        }
        System.out.println("没有找到对应的值："+value);
    }



    //递归遍历，适合所有链表，这里使用了consumer处理操作，分了前后操作，与springboot中的前后通知类似
    //递归递归，有递有归
    public void loop3(Consumer<Integer> before,Consumer<Integer> after){
        recursion(head.next,before,after);
    }
    private void recursion(Node current,Consumer<Integer> before,Consumer<Integer> after){
        if (current==head)return;
        //处理遍历的时候每个节点所需执行的操作
        before.accept(current.value);
        recursion(current.next,before,after);
        after.accept(current.value);
    }
}
