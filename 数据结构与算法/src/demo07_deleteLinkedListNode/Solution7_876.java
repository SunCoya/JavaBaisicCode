package demo07_deleteLinkedListNode;

//找到中间点
public class Solution7_876 {
    //快慢指针：看弹幕看了一眼：同时快慢指针也可以检测链表是否成环：龟兔赛跑
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1;
    }
}
