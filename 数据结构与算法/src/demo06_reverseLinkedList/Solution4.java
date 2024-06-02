package demo06_reverseLinkedList;

//方法四：通过指针记录1的位置（这里直接使用head），把1的位置后面的元素移动到最前面，最前面的位置需要用指针记录（n1）。
public class Solution4 {
    public static ListNode reverseList(ListNode head) {
        //记录链表第一个位置
        ListNode n1 = head;
        if (head==null||head.next==null)return head;
        ListNode p = null;
        while (head.next!=null){
            //记录提取的节点
            p  = head.next;
            //去除节点
            head.next = p.next;
            //把节点移动到第一位
            p.next=n1;
            //把第一位的标志变为该节点
            n1=p;
        }
        return p;
    }

}
