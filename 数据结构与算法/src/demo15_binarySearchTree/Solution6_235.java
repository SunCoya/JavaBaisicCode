package demo15_binarySearchTree;

public class Solution6_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root, b = root, point = root;
        while (true) {
            if (a.val>p.val)a=a.left;
            else if (a.val<p.val)a=a.right;
            if (b.val>q.val)b=b.left;
            else if (b.val<q.val)b=b.right;
            if (a==b)point=a;
            else break;
        }
        return point;
    }
    //太抽象了
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        //在同一侧，不在同一侧就返回（或者碰到一个节点）
        while (p.val<a.val&&q.val<a.val||p.val>a.val&&q.val>a.val) {
            if (a.val>p.val) a=a.left;
            else a=a.right;
        }
        return a;
    }
}
