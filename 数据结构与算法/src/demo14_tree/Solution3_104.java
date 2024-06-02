package demo14_tree;

import java.util.LinkedList;

public class Solution3_104 {
    public int maxDepth(TreeNode root) {
        if (root==null)return 0;
        //先找左右，后返回，是后序遍历的应用
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    public static int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int maxSize = 0;
        TreeNode pop=null;
        while(root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                maxSize = Math.max(maxSize,stack.size());
                root=root.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==null||peek.right==pop) pop=stack.pop();
                else root=peek.right;
            }
        }
        return maxSize;
    }

    public static int maxDepth3(TreeNode root) {
        if (root==null)return 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int maxSize = 0;
        linkedList.offer(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.poll();
                if (treeNode.left!=null)linkedList.offer(treeNode.left);
                if (treeNode.right!=null)linkedList.offer(treeNode.right);
            }
            maxSize++;
        }
        return maxSize;
    }
}
