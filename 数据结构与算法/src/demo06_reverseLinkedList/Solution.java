package demo06_reverseLinkedList;

//反转链表：方法一，创建一个新节点，也就是说最后会有两个链表
class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode add = null;
        while (p!=null){
            add = new ListNode(p.val,add);
            p=p.next;
        }
        return add;
    }
}