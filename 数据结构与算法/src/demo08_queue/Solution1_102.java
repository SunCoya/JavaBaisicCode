package demo08_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//二叉树层序遍历：还有三种为前中后
//层序遍历的思想：队列：先放节点，后处理一个一个处理节点，
//也可以一层一层处理，但是比较费空间
public class Solution1_102 {
    //自己写的方法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (root==null)return list;
        treeNodes.add(root);
        method(list,treeNodes);
        return list;
    }
    public void method(List<List<Integer>> list,ArrayList<TreeNode> treeNodes){
        ArrayList<Integer> valueList = new ArrayList<>();
        ArrayList<TreeNode> treeNodes2 = new ArrayList<>();
        if (treeNodes.isEmpty())return;
        for (TreeNode treeNode : treeNodes) {
            valueList.add(treeNode.val);
            if (treeNode.left!=null) treeNodes2.add(treeNode.left);
            if (treeNode.right!=null) treeNodes2.add(treeNode.right);
        }
        list.add(valueList);
        method(list,treeNodes2);
    }

    //力扣题解
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null)return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //记录大小，在这一次遍历中整出一层
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                arrayList.add(treeNode.val);
                if (treeNode.left!=null)queue.add(treeNode.left);
                if (treeNode.right!=null)queue.add(treeNode.right);
            }
            list.add(arrayList);
        }
        return list;
    }
}
