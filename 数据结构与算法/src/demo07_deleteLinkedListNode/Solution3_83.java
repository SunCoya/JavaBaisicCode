package demo07_deleteLinkedListNode;

//删除有序链表中的相同节点
public class Solution3_83 {
    //递归
    public ListNode deleteDuplicates(ListNode node) {
        if (node==null)return null;
        ListNode listNode = deleteDuplicates(node.next);
        node.next=listNode;
        if (listNode!=null&&listNode.val==node.val)return listNode;
        return node;
    }
    //第二种递归方式
    public ListNode deleteDuplicates1(ListNode node) {
        if (node==null||node.next==null)return node;
        if (node.val==node.next.val)return deleteDuplicates1(node.next);
        node.next=deleteDuplicates1(node.next);
        return node;
    }
    //双指针
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null)return null;
        ListNode p1=head;
        ListNode p2=head.next;
        while ((p2=p1.next)!=null){
            if (p1.val==p2.val){
                p1.next=p2.next;
            }else {
                p1=p2;
            }
        }
        return head;
    }
}
