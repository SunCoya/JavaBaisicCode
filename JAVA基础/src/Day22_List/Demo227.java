package Day22_List;

import java.util.LinkedList;

/*
LinkedList底层与LinkedList特有方法
LinkedList底层是双向链表：
1.源码中私有静态内部类是Node，包括item，prev，next
2.在List类中还有size，first，last代表规模和头尾节点
3.在new一个双向链表的时候，声明了size，first，last，全是空
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
1.在addLast后，先设置一个l保存last
2.new了一个新节点new Node<>(l,e,null)(前一个元素，添加的元素，后一个元素)
3.把last定义为新增加的这个节点
4.如果last节点本来为空（也就是说这个双向链表才刚刚创建），那就把头节点first也设置为新增的元素
否则就设置l（前一个元素）的下一个节点为新增的元素

通过上面的代码我们可以看到，Java中LinkedList如果有至少一个节点
这个双向链表中的头节点和尾节点就都不是指向的空(根本就没有创建这种内部类的对象，只是起一个指向作用)
*/
public class Demo227 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("LinkedList独有的增删查方法");
        linkedList.addFirst(1);
        linkedList.addLast(2);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
