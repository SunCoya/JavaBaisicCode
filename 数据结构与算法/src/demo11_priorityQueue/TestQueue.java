package demo11_priorityQueue;

import org.junit.jupiter.api.Test;

public class TestQueue {
    @Test
    public void poll(){
        PriorityQueue<Entry> queue = new PriorityQueue<>(5);
        queue.offer(new Entry(3,"task1"));
        queue.offer(new Entry(5,"task2"));
        queue.offer(new Entry(4,"task3"));
        queue.offer(new Entry(1,"task4"));
        queue.offer(new Entry(2,"task5"));
        System.out.println(queue.offer(new Entry(2, "task6")));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
    @Test
    public void poll2(){
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry(3,"task1"));
        queue.offer(new Entry(5,"task2"));
        queue.offer(new Entry(4,"task3"));
        queue.offer(new Entry(1,"task4"));
        queue.offer(new Entry(2,"task5"));
        System.out.println(queue.offer(new Entry(2, "task6")));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void poll3(){
        PriorityQueue3<Entry> queue = new PriorityQueue3<>(5);
        queue.offer(new Entry(3,"task1"));
        queue.offer(new Entry(5,"task2"));
        queue.offer(new Entry(4,"task3"));
        queue.offer(new Entry(1,"task4"));
        queue.offer(new Entry(2,"task5"));
        System.out.println(queue.offer(new Entry(2, "task6")));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void testLiKou(){
        Solution1_23 solution = new Solution1_23();
        ListNode listNode16 = new ListNode(0,null);
        ListNode listNode15 = new ListNode(-1,listNode16);
        ListNode listNode14 = new ListNode(-1,listNode15);
        ListNode listNode13 = new ListNode(-3,listNode14);
        ListNode listNode12 = new ListNode(-9,listNode13);
        ListNode listNode11 = new ListNode(-9,listNode12);
        ListNode listNode1 = new  ListNode(-10,listNode11);

        ListNode listNode2 = new  ListNode(-5,null);
        ListNode listNode3 = new  ListNode(4,null);
        ListNode listNode4 = new  ListNode(-8,null);
        ListNode listNode5 = null;

        ListNode listNode66 = new ListNode(3,null);
        ListNode listNode65 = new ListNode(2,listNode66);
        ListNode listNode64 = new ListNode(-2,listNode65);
        ListNode listNode63 = new ListNode(-4,listNode64);
        ListNode listNode62 = new ListNode(-5,listNode63);
        ListNode listNode61 = new ListNode(-6,listNode62);
        ListNode listNode6 = new  ListNode(-9,listNode61);

        ListNode listNode74 = new ListNode(0,null);
        ListNode listNode73 = new ListNode(-1,listNode74);
        ListNode listNode72 = new ListNode(-2,listNode73);
        ListNode listNode71 = new ListNode(-3,listNode72);
        ListNode listNode7 = new  ListNode(-3,listNode71);

        ListNode[] listNodes = {listNode1,listNode2,listNode3,listNode4,listNode5,listNode6,listNode7};
        ListNode listNode = solution.mergeKLists2(listNodes);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
