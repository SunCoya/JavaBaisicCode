package demo14_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1_144_94_145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null)return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                integerList.add(root.val);
                root=root.left;
            }else {
                root=stack.pop();
                root=root.right;
            }
        }
        return integerList;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root = stack.pop();
                integerList.add(root.val);
                root=root.right;
            }
        }
        return integerList;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop=null;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right==null||peek.right==pop){
                    pop = stack.pop();
                    integerList.add(pop.val);
                }else {
                    root=peek.right;
                }
            }
        }
        return integerList;
    }
}
