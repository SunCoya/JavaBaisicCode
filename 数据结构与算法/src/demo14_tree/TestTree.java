package demo14_tree;

import org.junit.jupiter.api.Test;

public class TestTree {
    @Test
    public void testTravel() {
        /*
                       1
                   2       3
                 4       5   6
        */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        TreeTraversal.preOrder(root);
        System.out.println();
        TreeTraversal.inOrder(root);
        System.out.println();
        TreeTraversal.postOrder(root);
        System.out.println();
        TreeTraversal.preOrder2(root);
        System.out.println();
        TreeTraversal.preOrder3(root);
        System.out.println();
        TreeTraversal.inOrder2(root);
        System.out.println();
        TreeTraversal.postOrder2(root);
        System.out.println();
        TreeTraversal.order(root, 1);
        TreeTraversal.order(root, 2);
        TreeTraversal.order(root, 3);
    }

    @Test
    public void testLiKou() {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        Solution7_105  solution = new Solution7_105();
        TreeNode treeNode = solution.buildTree(a, b);
        TreeTraversal.preOrder(treeNode);
        TreeTraversal.inOrder(treeNode);
    }
    @Test
    public void testBuildTree(){
        String[] strings = {"3","2","+","1","-"};
        Solution6.TreeNode treeNode = Solution6.constructExpressionTree(strings);
        //后序遍历
        Solution6.method(treeNode);
        System.out.println();
        //因为新的符号也会入栈，最里面的数字也会假如到哦树的最左叶子上面
        String[] strs = {"1","6","9","3","+","1","*","/","*","1","+","5","+"};
        treeNode = Solution6.constructExpressionTree(strs);
        Solution6.method(treeNode);
    }
}