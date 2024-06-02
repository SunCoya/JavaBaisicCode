package demo14_tree;

public class Solution8_106 {
    int[] inorder,postorder;
    int[] arr = new int[6001];
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        this.postorder=postorder;
        this.inorder=inorder;
        for (int i = 0; i < inorder.length; i++) arr[inorder[i]+3000]=i;
        return method(postorder.length-1,inorder.length-1,inorder.length);
    }
    //i post，j in
    public TreeNode method(int i,int j,int length){
        if (length==0)return null;
        int value = postorder[i];
        TreeNode root = new TreeNode(value);
        int index = arr[value+3000];
        root.right = method(i-1,j,j-index);
        root.left = method(i-1+index-j,index-1,length+index-j-1);
        return root;
    }
}
