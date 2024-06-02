package demo14_tree;

import java.util.LinkedList;

public class Solution2_101 {
    public boolean isSymmetric(TreeNode root) {
        return travel(root.left,root.right);
    }
    public boolean travel(TreeNode a,TreeNode b){
        if (a==null&&b==null)return true;
        if (a==null||b==null||a.val!=b.val) return false;
        return travel(a.left,b.right)&&travel(a.right,b.left);
    }
    public static boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left==null&&right==null)return true;
        if (left==null||right==null)return false;
        while (left!=null||right!=null||!stack1.isEmpty()||!stack2.isEmpty()){
            if (left!=null&&right!=null){
                if (left.val!=right.val)return false;
                stack1.push(left);
                stack2.push(right);
                left=left.left;
                right=right.right;
            }
            else if (left==null&&right==null){
                left=stack1.pop();
                right=stack2.pop();
                left=left.right;
                right=right.left;
            }
            else return false;
        }
        return true;
    }
}
