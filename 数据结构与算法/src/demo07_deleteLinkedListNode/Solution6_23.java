package demo07_deleteLinkedListNode;

import java.util.Arrays;
//合并多个有序链表
public class Solution6_23 {
    //类比前面的，不用全部一起和并，一个 一个合并就可以了，我们用二分尽量减少合并的次数，比如四个链表，两两合并只要三次，一个一个和要4次
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length==0)return null;
        if (lists.length==1)return lists[0];
        if (lists.length==2)return mergeTwoLists(lists[0],lists[1]);
        int length = lists.length;
        int index = length>>>1;
        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists,0,index)),mergeKLists(Arrays.copyOfRange(lists,index,length)));
    }
    //非递归的实现效率更高
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode sentinel = new ListNode(0, null);
        if (p1 == null) return p2;
        ListNode p0 = sentinel;
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
        if (p1 == null) p0.next = p2;
        else p0.next = p1;
        return sentinel.next;
    }
}
