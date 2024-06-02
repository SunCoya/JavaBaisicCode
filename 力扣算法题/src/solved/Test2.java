package solved;
/*
写成这样已经是我的全部实力了
*/
public class Test2 {
    public static void main(String[] args) {
        ListNode l1 =
                new ListNode(2,
                new ListNode(4,
                new ListNode(3
           )));
        ListNode l2 =
                new ListNode(5,
                new ListNode(6,
                new ListNode(4
                )));
        ListNode ans = addTwoNumbers(l1,l2);
        sout(ans);
    }

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //头节点
        ListNode head = new ListNode();
        ListNode p = head;
        while (true){
            int num1=0,num2=0;
            //先判断两个节点：都不为空就往后走，为空就不管了
            if(l1!=null){
                num1=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                num2=l2.val;
                l2=l2.next;
            }
            //获取总的值：分开讨论：大于等于10和小于10
            int sum = p.val+ num1+ num2;
            if (sum<10){
                p.val=sum;
                //两个节点都不为空才new下一个node
                if (l1!=null||l2!=null)
                p.next = new ListNode();
                else break;
            }else {
                p.val=sum%10;
                p.next = new ListNode(1);
            }
            p=p.next;
        }
        return head;
    }

    public static void sout(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}