package demo06_reverseLinkedList;

//方法二：创建内部类当作容器，移除一个节点，在另一个链表中加一个节点，更节省空间，用双指针可看方法五
public class Solution2 {
    public static ListNode reverseList(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true){
            ListNode first = list1.removeFirst();
            if (first==null)break;
            list2.addFirst(first);
        }
        return list2.head;
    }
    static class List{
        ListNode head;
        public List(ListNode head){
            this.head=head;
        }
        public void addFirst(ListNode first){
            first.next=head;
            head=first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first!=null){
                head = first.next;
            }
            return first;
        }
    }
}
