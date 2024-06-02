package demo10_deque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offerFirst(root);
        int count = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            LinkedList<Integer> integerLinkedList = new LinkedList<>();
            //把队列里面的所有数据清除，从左到右加入
            //一般是pollFirst，offerLast
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.poll();
                //只要在这个地方改一改就行了，偶数层倒着放，不应该再linkedList里面动手，应该在结果上面的集合动手
                if (count%2==0)integerLinkedList.offer(treeNode.val);
                else integerLinkedList.offerFirst(treeNode.val);
                if (treeNode.left != null) linkedList.offer(treeNode.left);
                if (treeNode.right != null) linkedList.offer(treeNode.right);
            }
            list.add(integerLinkedList);
            count++;
        }
        return list;
    }
}
