package demo06_reverseLinkedList;

//方法三：递归
//递-找最后一个节点
//归-从最后一个节点开始改：后一个节点指向该节点，该节点指向空，然后由函数返回
public class Solution3 {
    public static ListNode reverseList(ListNode p) {
        if (p==null||p.next==null) return p;

        ListNode listNode = reverseList(p.next);

        p.next.next=p;
        //必要，否则第一个节点会指向第二个节点造成死循环
        p.next=null;
        return listNode;
    }
}
