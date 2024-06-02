package demo14_tree;

import java.util.LinkedList;

public class TreeTraversal {
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    //非递归实现-一去不复返，整不会了
    //问题，用栈：去的时候回来了，但是只能回来一个，又去相同的路了
    //我觉得自己的挺好了，不知道怎么改了（好了，看了老师的方法，自己的就是依托，好吧记录最近弹栈也是自己想出来的）
    static void preOrder2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //这里前序
            node=node.left!=null?node.left:node.right;
            if (node!=null){
                stack.push(node);
                continue;
            }
            //回家
            while (!stack.isEmpty()) {
                TreeNode outNode = stack.pop();
                //这里和下面的一段代码中序
                if (outNode.right==null)System.out.print(outNode.val+" ");
                node=stack.peek();
                if (node!=null&&node.right!=null&&node.right!=outNode){
                    System.out.print(node.val+" ");
                    node=node.right;
                    //这里后序
                    stack.push(node);
                    break;
                }
            }
        }
    }
    //老师的方法先判断左后判断右，没有和我一样同时判断。
    //这个在root之后就没留着了
    static void preOrder3(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                System.out.print(node.val+" ");
                stack.push(node);
                node=node.left;
            }else {
                node = stack.pop();
                node=node.right;
            }
        }
    }
    static void inOrder2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node!=null || !stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node = stack.pop();
                System.out.print(node.val+" ");
                node=node.right;
            }

        }
    }

    static void postOrder2(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode outNode=null;
        while (node!=null||!stack.isEmpty()) {
            if (node!=null){
                stack.push(node);
                node= node.left;
            }else {
                //问题：不弹出栈造成死循环
                TreeNode peek= stack.peek();
                //怎么知道右子处理了呢
                //最近弹出的如果是右孩子，那么就要弹出这一个
                if (peek.right==null||peek.right==outNode){
                    outNode=stack.pop();
                    System.out.print(outNode.val+" ");
                }else node=peek.right;
            }
        }
    }

    static void order (TreeNode node,int i) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode outNode=null;
        while (node!=null||!stack.isEmpty()) {
            if (node!=null){
                if (i==1) System.out.print(node.val+" ");
                stack.push(node);
                node= node.left;
            }else {
                TreeNode peek= stack.peek();
                if (i==2&&peek.right==null)System.out.print(peek.val+" ");
                //右子树空或者右子树刚刚处理掉
                if (peek.right==null||peek.right==outNode){
                    outNode=stack.pop();
                    if (i==3) System.out.print(outNode.val+" ");
                }else {
                    node=peek.right;
                    if (i==2) System.out.print(peek.val+" ");
                }
            }
        }
    }

}
