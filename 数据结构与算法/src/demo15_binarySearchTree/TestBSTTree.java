package demo15_binarySearchTree;

import demo15_binarySearchTree.BinarySearchTree2.BSTNode;
import org.testng.annotations.Test;


public class TestBSTTree {
    @Test
    public void testBST(){
        /*
        *           4
        *        2     6
        *      1  3   5  7
        * */
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.BSTNode n1 = new BinarySearchTree.BSTNode(1,1);
        BinarySearchTree.BSTNode n3 = new BinarySearchTree.BSTNode(3,3);
        BinarySearchTree.BSTNode n5 = new BinarySearchTree.BSTNode(5,5);
        BinarySearchTree.BSTNode n7 = new BinarySearchTree.BSTNode(7,7);
        BinarySearchTree.BSTNode n2 = new BinarySearchTree.BSTNode(2,2,n1,n3);
        BinarySearchTree.BSTNode n6 = new BinarySearchTree.BSTNode(6,6,n5,n7);
        tree.root= new BinarySearchTree.BSTNode(4,4,n2,n6);
        System.out.print(tree.get(1));
        System.out.print(tree.get(2));
        System.out.print(tree.get(3));
        System.out.print(tree.get(4));
        System.out.print(tree.get(5));
        System.out.print(tree.get(6));
        System.out.print(tree.get(7));
        System.out.print(tree.get(8));
        System.out.println();
        System.out.print(tree.max());
        System.out.print(tree.min());
        System.out.println();
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.put(4,4);
        tree2.put(2,2);
        tree2.put(6,6);
        tree2.put(1,1);
        tree2.put(3,3);
        tree2.put(7,7);
        tree2.put(5,5);
        System.out.println(isSameNode(tree.root,tree2.root));
        tree2.put(1,8);
        System.out.println(tree.get(1));
        System.out.println(isSameNode(tree.root,tree2.root));
    }
    public boolean isSameNode(BinarySearchTree.BSTNode root1,BinarySearchTree.BSTNode root2){
        if (root1==null&&root2==null)return true;
        if (root1==null||root2==null)return false;
        if (!root1.value.equals(root2.value))return false;
        return isSameNode(root1.left,root2.left)&&isSameNode(root1.right,root2.right);
    }
    @Test
    public void testBST2(){
        BinarySearchTree2<String,Integer> tree = new BinarySearchTree2<>();
        BSTNode<String,Integer> n1 = new BSTNode<>("1",1);
        BSTNode<String,Integer> n3 = new BSTNode<>("3",3);
        BSTNode<String,Integer> n5 = new BSTNode<>("5",5);
        BSTNode<String,Integer> n7 = new BSTNode<>("7",7);
        BSTNode<String,Integer> n2 = new BSTNode<>("2",2,n1,n3);
        BSTNode<String,Integer> n6 = new BSTNode<>("6",6,n5,n7);
        tree.root= new BSTNode<>("4",4,n2,n6);
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.get("3"));
        System.out.println(tree.get("4"));
        System.out.println(tree.get("5"));
        System.out.println(tree.get("6"));
        System.out.println(tree.get("7"));
        System.out.println(tree.get("8"));
    }

    @Test
    public void testDelete(){
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.BSTNode n1 = new BinarySearchTree.BSTNode(1,1);
        BinarySearchTree.BSTNode n3 = new BinarySearchTree.BSTNode(3,3);
        BinarySearchTree.BSTNode n6 = new BinarySearchTree.BSTNode(6,6);
        BinarySearchTree.BSTNode n5 = new BinarySearchTree.BSTNode(5,5,null,n6);
        BinarySearchTree.BSTNode n2 = new BinarySearchTree.BSTNode(2,2,n1,n3);
        BinarySearchTree.BSTNode n7 = new BinarySearchTree.BSTNode(7,7,n5,null);
        tree.root= new BinarySearchTree.BSTNode(4,4,n2,n7);
        /*
         *           4
         *        2       7
         *      1  3   5
         *              6
         * */
        System.out.println(tree.delete(4));
        tree.sequenceTraversal();
        tree.delete2(2);
        tree.sequenceTraversal();
    }


    @Test
    public void testFanWei(){
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.BSTNode n1 = new BinarySearchTree.BSTNode(1,1);
        BinarySearchTree.BSTNode n3 = new BinarySearchTree.BSTNode(3,3);
        BinarySearchTree.BSTNode n6 = new BinarySearchTree.BSTNode(6,6);
        BinarySearchTree.BSTNode n5 = new BinarySearchTree.BSTNode(5,5,null,n6);
        BinarySearchTree.BSTNode n2 = new BinarySearchTree.BSTNode(2,2,n1,n3);
        BinarySearchTree.BSTNode n7 = new BinarySearchTree.BSTNode(7,7,n5,null);
        tree.root= new BinarySearchTree.BSTNode(4,4,n2,n7);
        /*
         *           4
         *        2       7
         *      1  3   5
         *              6
         * */
        System.out.println(tree.less(6));
        System.out.println(tree.greater(2));
        System.out.println(tree.between(1,7));

    }
    /*
     *               4
     *           2         6
     *         1  3     5    7
     *          2.5
     *
     * */
    @Test
    public void testLIKOU(){
        int[] arr = {8,5,1,7,10,12};
        new Solution5_1008().bstFromPreorder2(arr);
    }
}
