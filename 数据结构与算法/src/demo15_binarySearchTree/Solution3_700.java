package demo15_binarySearchTree;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

//判断合法二叉树
public class Solution3_700 {
    Long min = Long.MIN_VALUE;
    //递归中序号遍历，我遍历划范围做的，比较麻烦
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        boolean a= isValidBST(root.left);
        //坑1：枝剪，左子错直接返回，不要判断右子了
        if (!a)return false;
        //断点右键在Condition加条件
        if (root.val<= min)return false;
        min= (long) root.val;
        //前面错直接返回
        return isValidBST(root.right);
    }

    //不用全局参数做法：传对象
    public boolean isValidBST1(TreeNode root) {
        return doValid(root,new AtomicLong(Long.MIN_VALUE));
    }
    public boolean doValid(TreeNode root, AtomicLong min){
        if (root==null)return true;
        boolean a= isValidBST(root.left);
        if (!a)return false;
        if (root.val<= min.get())return false;
        min.set(root.val);
        return isValidBST(root.right);
    }


    //中序遍历就可，不过这个比较慢
    public boolean isValidBST2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        long i=Long.MIN_VALUE;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root = stack.pop();
                if (root.val<=i)return false;
                i=root.val;
                root=root.right;
            }
        }
        return true;
    }


    //自己的上下界方法，老师也讲了
    public boolean isValidBST3(TreeNode root) {
        return isValid(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValid(TreeNode root, long max, long min) {
        if (root==null)return true;
        if (root.val>max||root.val<min)return false;
        return isValid(root.right,max, (long)root.val+1)&&isValid(root.left,(long)root.val-1, min);
    }
}
