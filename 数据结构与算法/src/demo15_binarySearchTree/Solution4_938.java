package demo15_binarySearchTree;

public class Solution4_938 {
    //求范围内的数字和，啥也不管，全部遍历！！！
    //不剪不行啊。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int right = 0,left=0,a = root.val;
        //非，不合法，这里只考虑a的改变
        if (root.val<low||root.val>high)a=0;
        //还能左靠
        if (root.val>=low)left = rangeSumBST(root.left,low,high);
        //还能右边靠
        if (root.val<=high)right = rangeSumBST(root.right, low, high);
        return left+right+a;
    }

    //有时候不省或许效率还简介一点
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val<low)return rangeSumBST2(root.right,low,high);
        else if (root.val>high)return rangeSumBST2(root.left,low,high);
        return rangeSumBST(root.right, low, high)+rangeSumBST(root.left,low,high)+root.val;
    }
}
