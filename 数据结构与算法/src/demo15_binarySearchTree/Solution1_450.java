package demo15_binarySearchTree;
//删除二叉搜索树中的节点
public class Solution1_450 {
    TreeNode root;
    public TreeNode deleteNode(TreeNode root, int key) {
        this.root=root;
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            if (key == p.val) break;
            parent = p;
            if (key > p.val) p = p.right;
            else p = p.left;
        }
        //找不到数字，或者p为空，返回root就行
        if (p == null) return this.root;
        if (p.left == null) shift(parent, p, p.right);
        //else别轻易丢
        else if (p.right == null) shift(parent, p, p.left);
        else {
            TreeNode rightMin = p.right;
            TreeNode rightParent = null;
            while (rightMin.left != null) {
                rightParent = rightMin;
                rightMin = rightMin.left;
            }
            shift(parent, p, rightMin);
            rightMin.left = p.left;
            if (rightParent != null) {
                shift(rightParent, rightMin, rightMin.right);
                rightMin.right = p.right;
            }
        }
        return this.root;
    }

    public void shift(TreeNode parent, TreeNode deleted, TreeNode child) {
        if (parent == null) root = child;
        else if (parent.right == deleted) parent.right = child;
        else parent.left = child;
    }
}
