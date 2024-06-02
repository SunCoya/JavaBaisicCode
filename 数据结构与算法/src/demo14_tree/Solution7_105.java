package demo14_tree;

public class Solution7_105 {
    //画一个图就发现可以使用递归构造树，这个还不是最佳做法
    //用了数组减少搜索，还是2ms，算了，够了！
    int[] preorder,inorder;
    //简陋哈希表
    int[] arr = new int[6001];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        for (int i = 0; i < inorder.length; i++) arr[inorder[i]+3000]=i;
        return method(0,0,preorder.length);
    }
    public TreeNode method(int i,int j,int length){
        if (length==0)return null;
        int value = preorder[i];
        TreeNode root = new TreeNode(value);
        int index = arr[value+3000];
        root.left = method(i+1,j,index-j);
        root.right = method(i+1+index-j,index+1,length-index+j-1);
        return root;
    }
}
