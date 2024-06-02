package demo07_deleteLinkedListNode;

/*
* 快慢指针：找到链表中环的入口
*
* 如果head就在环上，在哪里相遇？在开始的地方
* 如果head不在环上，有一个地方为开始的地方：-0，相遇的时候会在哪里呢？
* 入环口-1，此时把兔子放到开头，龟龟不动，两个人一次走一格，相遇的地方就是环的入口
*
* 原理：
* 若起点到入口的距离为a，从起点开始，走a+绕环n圈，走到入口
* 第一次相遇的
* 兔子走了a+xn圈
* 龟龟走了a+yn圈
* 兔兔-龟龟=龟龟 = （x-y）圈
* 如果龟龟+a，就能到入口（前面的第一点）
* a怎么知道呢？把兔兔放第一个，再给它降低速度，两人走到一起就变成了环入口的地方啦
* */
public class Solution9_141_142 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2)return true;
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){
                p1=head;
                while(p1==p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
