package demo14_tree;

public class Solution5_226 {
    public TreeNode invertTree(TreeNode root) {
        method(root);
        return root;
    }
    public void method(TreeNode root){
        if (root==null)return;
        TreeNode t = root.left;
        root.left=root.right;
        root.right=t;
        method(root.left);
        method(root.right);
    }
}
