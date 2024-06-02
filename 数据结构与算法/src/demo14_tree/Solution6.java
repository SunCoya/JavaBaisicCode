package demo14_tree;
import java.util.LinkedList;

//根据后缀表达式构造表达式树
//假如是31+2-应该是
/*
              -
         +        2
     3      1
把数字压入栈，碰到运算符号则出栈，运算符入栈：运算符也是树的一部分
先出栈的应该的是右孩子
对这个树进行后序号遍历就能得到中序表达式
*/
public class Solution6 {
    public static TreeNode constructExpressionTree(String[] tokens){
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token){
                case "+","-","*","/"->{
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode root  = new TreeNode(token,left,right);
                    //再把符号压入栈
                    stack.push(root);
                }
                default -> stack.push(new TreeNode(token,null,null));
            }
        }
        //最后栈中还剩下一个
        return stack.pop();
    }

    public static void method(TreeNode root){
        if (root==null)return ;
        method(root.left);
        method(root.right);
        System.out.print(root.val);
    }
    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        public TreeNode(String val) {
            this.val = val;
        }
        public TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

