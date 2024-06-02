package demo07_deleteLinkedListNode;

//删除某个值的节点
public class Solution1_206 {
    //自己写的方法
    //如果每次只看当前节点，就不太好去删除--因为要找上一个节点,原来的做法是用循环先找到第一个不用删除的节点
    //这里直接new一个新的哨兵节点，更好处理
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel=new ListNode(0,head);
        ListNode p = sentinel;
        while (p!=null&&p.next!=null){
            ListNode node = p.next;
            while (node!=null&&node.val==val)node=node.next;
            p.next = node;
            p=node;
        }
        return sentinel.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        //这里用双指针比自己写的更加清晰！多用吧，少循环了
        ListNode sentinel=new ListNode(0,head);
        ListNode p1 = sentinel;
        ListNode p2 = p1.next;
        while (p2!=null){
            if (p2.val==val) {
                p2 = p2.next;
                p1.next = p2;
            }
            else {
                p1=p2;
                p2= p2.next;
            }
        }
        return sentinel.next;
    }
    public static ListNode removeElements3(ListNode node, int val) {
        if (node==null)return null;
        //遇到相等的节点就返回它的下一个节点，这个节点就不要了。。。这个是真简洁
        if (node.val==val)return removeElements3(node.next,val);
        node.next=removeElements3(node.next,val);
        return node;
    }
}
