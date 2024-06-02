package demo07_deleteLinkedListNode;

//力扣第19题，刚开始用静态变量记录，但是力扣中不能这么做！！！别用
public class Solution2_19 {
    //递归，创建新函数，通过返回值来计数
    public static ListNode removeNthFromEnd(ListNode node, int n) {
        ListNode sentinel = new ListNode(0,node);
        recursion(sentinel,n);
        return sentinel.next;
    }
    public static int recursion(ListNode node,int n){
        if (node==null)return 0;
        int nth = recursion(node.next,n);//下一个节点的倒数位置
        if (nth==n)node.next=node.next.next;
        return nth+1;
    }

    //双指针：自己的思路：先循环，后指针的next为空的时候，前指针的next就是目标
    //应该有一个头头
    public static ListNode removeNthFromEnd2(ListNode node, int n) {
        ListNode sentinel = new ListNode(0,node);
        ListNode p1=sentinel;
        ListNode p2=sentinel;
        for (int i = 0; i < n; i++) p2=p2.next;
        while (p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return sentinel.next;
    }
}
