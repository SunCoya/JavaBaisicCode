package demo07_deleteLinkedListNode;


public class Solution5_21 {
        //递归，莫名奇妙做对了，改进一下，注意需要返回的节点是什么，该节点的该指向哪一个
        public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
            //可以去掉两个同时判断
            if (p1 == null) return p2;
            if (p2 == null) return p1;
            if (p1.val <= p2.val) {
                p1.next = mergeTwoLists(p1.next, p2);
                return p1;
            }
            else {
                p2.next = mergeTwoLists(p1, p2.next);
                return p2;
            }
        }

    //合并有序链表，自己完成
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(0, null);
        if (list1 == null) return list2;
        ListNode p0 = sentinel;
        ListNode p1 = list1;
        ListNode p2 = list2;
        //两个链表同时都存在数字的时候
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                p0.next = p2;
                p2 = p2.next;
            } else {
                p0.next = p1;
                p1 = p1.next;
            }
            p0 = p0.next;
        }
        //接下来残留的某个链表
        if (p1 == null) p0.next = p2;
        else p0.next = p1;
        return sentinel.next;
    }
}
