package demo15_binarySearchTree;

//给定前序遍历给出二叉搜索树，第一种思路是从左向右依次插入（效率较低）（我还没想到有这种方法）
public class Solution5_1008 {
    //递归，第一个是本节点，第二个是左子，找到第一个大的就是右子
    //可以把j设置为右边界，两种方法都可以，我觉得后者或许好一点，时间复杂度比上界方法稍逊一筹，也是ologn
    public TreeNode bstFromPreorder(int[] preorder) {
        return doBuild(preorder, 0, preorder.length - 1);
    }
    public TreeNode doBuild(int[] arr, int i, int j) {
        if (i > j) return null;
        int index;
        //找下标
        for (index = i; index < j; index++) if (arr[index + 1] > arr[i]) break;
        return new TreeNode(arr[i], doBuild(arr, i + 1, index), doBuild(arr, index + 1, j));
    }



    //上界方法，递归，在归的时候也创建节点。第一个自己，第二个老师，都可。可以不用看
    public TreeNode bstFromPreorder2(int[] preorder) {
        return doBuild2(preorder, Integer.MAX_VALUE);
    }
    int index = 0;
    public TreeNode doBuild2(int[] arr, int max) {
        TreeNode node = new TreeNode(arr[index]);
        if (index + 1 > arr.length - 1) return node;
        if (arr[index + 1] < arr[index]) node.left = doBuild2(arr, arr[index++]);
        if (index + 1 > arr.length - 1) return node;
        if (arr[index+1] < max) {
            index++;
            node.right = doBuild2(arr, max);
        }
        return node;
    }
    public TreeNode doBuild3(int[] arr, int max) {
        if (index==arr.length)return null;
        int val = arr[index];
        //新来节点大于上一个节点的max时候返回空
        if (val>max)return null;
        TreeNode node = new TreeNode(val);
        index++;
        node.left=doBuild3(arr,val);
        node.right=doBuild3(arr,max);
        return node;
    }
}
