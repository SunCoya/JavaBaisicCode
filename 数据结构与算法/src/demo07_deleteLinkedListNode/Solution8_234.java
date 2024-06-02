package demo07_deleteLinkedListNode;

//判断回文链表
//思路是找到中间的节点：如果是奇数个应该怎么办呢：最后一个不比就可以咯
public class Solution8_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode node = middleNode(head);

        //反转链表，反转后的头节点为p1
        ListNode p1 = node;
        ListNode p2 = p1.next;
        p1.next = null;
        ListNode p3 = p2;
        while (p3 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        //比较前面的内容
        while (head != node) {
            if (head.val != p1.val) return false;
            head = head.next;
            p1 = p1.next;
        }
        return true;
    }

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    //优化：把找中间点和反转链表结合，反转哪一个呢？反转前面的链表
    public boolean isPalindrome2(ListNode head) {
        ListNode p1=head,p2=head;
        //初始化头节点
        ListNode n1=null;
        while (p2!=null&&p2.next!=null){
            //记录被抛弃的节点
            ListNode o1 = p1;
            //向后移动指针
            p1=p1.next;
            p2=p2.next.next;
            //头节点原来后面的第一个的节点
            o1.next=n1;
            n1 = o1;
        }
        //为奇数个节点需要移动一位
        if (p2!=null)p1=p1.next;

        while (n1 != null) {
            if (n1.val != p1.val) return false;
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}
