package demo15_binarySearchTree;

public class Solution2_701 {
    //递归方法，多出赋值操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null)return new TreeNode(val);
        if (val< root.val)root.left=insertIntoBST(root.left,val);
        else root.right = insertIntoBST(root.right,val);
        return root;
    }
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root==null)return new TreeNode(val);
        TreeNode p = root;
        TreeNode parent=null;
        while (p!=null){
            parent=p;
            if (val>p.val)p=p.right;
            else p=p.left;
        }
        if (val> parent.val)parent.right=new TreeNode(val);
        else parent.left = new TreeNode(val);
        return root;
    }
}
