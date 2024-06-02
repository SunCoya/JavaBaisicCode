package demo07_deleteLinkedListNode;

//删除有序链表中，重复了的元素全部死刑！
public class Solution4_82 {
    public ListNode deleteDuplicates(ListNode node) {
        if (node==null||node.next==null)return node;
        if (node.val==node.next.val){//直到找到不重复的指针
            ListNode listNode = node.next.next;//定义新的指针，去找，到这里才会自己写
            while (listNode!=null&&listNode.val==node.val)listNode=listNode.next;
            return deleteDuplicates(listNode);//返回不重复的那一个指针
        }
        node.next=deleteDuplicates(node.next);
        return node;
    }
    //双指针，比较繁琐
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null||head.next==null)return head;

        ListNode sentinel = new ListNode(0,head);
        ListNode p1 = sentinel;
        ListNode p2;
        while ((p2=p1.next)!=null&&p2.next!=null){
            if (p2.val==p2.next.val){
                ListNode p3 = p2.next.next;
                while (p3!=null&&p3.val==p2.val)p3=p3.next;
                p1.next=p3;
            }
            else p1=p1.next;
        }
        return sentinel.next;
    }
}
