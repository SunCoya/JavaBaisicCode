package demo14_tree;

import java.util.LinkedList;

public class Solution4_111 {
    //不太可，要遍历全部才可
    public int minDepth(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null&&root.right==null)return 1;
        else if (root.left==null)return minDepth(root.right)+1;
        else if (root.right==null)return minDepth(root.left)+1;
        else return Math.min(minDepth(root.right),minDepth(root.left))+1;
    }
    //这个就层序遍历快一点
    public static int minDepth2(TreeNode root) {
        if (root==null)return 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int minSize = 0;
        linkedList.offer(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.poll();
                if (treeNode.left!=null)linkedList.offer(treeNode.left);
                if (treeNode.right!=null)linkedList.offer(treeNode.right);
                if (treeNode.left==null&&treeNode.right==null){
                    return minSize+1;
                }
            }
            minSize++;
        }
        return minSize;
    }
}
