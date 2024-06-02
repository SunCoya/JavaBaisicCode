package demo06_reverseLinkedList;

public class Test {
    public static void main(String[] args) {
        ListNode a4 = new ListNode(1, null);
        ListNode a3 = new ListNode(2, a4);
        ListNode a2 = new ListNode(3, a3);
        ListNode a1 = new ListNode(4, a2);

        //ListNode listNode = Solution.reverseList(a1);
        //listNode = Solution2.reverseList(listNode);
        //ListNode listNode = Solution3.reverseList(a1);
        ListNode listNode = Solution5.reverseList(a1);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
