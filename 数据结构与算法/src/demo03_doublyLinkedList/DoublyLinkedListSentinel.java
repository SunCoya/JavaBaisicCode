package demo03_doublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }
            @Override
            public Integer next() {
                int result = p.value;
                p=p.next;
                return result;
            }
        };
    }

    /**
     * 双向链表节点
     * 前一个节点，后一个节点
    * */
    static class Node{
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
    final private Node tail;
    //线创建对象再连接，否则head会指向为空
    public DoublyLinkedListSentinel(){
        head = new Node(0,null,null);
        tail = new Node(0,null,null);
        head.next=tail;
        tail.prev=head;
    }

    private Node findNode(int index){
        //从-1开始的头哨兵
        int i = -1;
        Node p = head;
        while(p!=tail&&index!=i){
            i++;
            p=p.next;
        }
        if (p==null) throw new IllegalArgumentException("index：" + index + "不合法");
        return p;
    }
    public void insert(int index,int value){
        Node nodeAfter = findNode(index);
        Node nodeBefore = nodeAfter.prev;
        Node node = new Node(value,nodeBefore,nodeAfter);
        nodeBefore.next=node;
        nodeAfter.prev=node;
    }
    public void addFirst(int value){
        insert(0,value);
    }



    public void addLast(int value){
        Node nodePre = tail.prev;
        Node node = new Node(value,nodePre,tail);
        nodePre.next=node;
        tail.prev=node;
    }

    public void remove(int index){
        Node node = findNode(index);
        if(node == head||node==tail) throw new IllegalArgumentException("index：" + index + "不合法");
        Node nodePre = node.prev;
        Node nodeNext= node.next;
        nodePre.next = nodeNext;
        nodeNext.prev=nodePre;
    }

    public void removeLast(){
        Node node = tail.prev;
        if (node==head) throw new NullPointerException("已经删完啦！");
        Node nodePre = node.prev;
        nodePre.next=tail;
        tail.prev=nodePre;
    }
}
