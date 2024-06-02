package demo06_reverseLinkedList;

public class Solution5 {
    //方法五：也是用指针，o1记录老链表的第一个位置，n1记录新链表的第一个位置
    public static ListNode reverseList(ListNode head) {
        //记录链表第一个位置
        ListNode o1 = head;
        ListNode n1 = null;
        while (o1 != null) {
            //记录老链表第二个位置
            ListNode p = o1.next;
            //把提取的节点放到新节点的第一个
            o1.next = n1;
            //跟新n1与o1
            n1 = o1;
            o1 = p;
        }
        return n1;
    }
}
