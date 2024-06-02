package demo15_binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    //相对于二分查找，需要已经排序的数组，且在假如新结构时不需要额外排序
    //二叉搜索树||二叉排序树，需要给二叉搜索树的每个节点上加一个key属性，key用来比较谁大谁小，且不能重复
    //对于任意一个节点左子树中所有节点都要小于，右子树所有节点都要大于
    //遍历使用中序，找节点大于则右走小于则左走
    static class BSTNode {
        //和map差不多，都是根据key去快速找值
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode root;

    public Object get(int key) {
        BSTNode p = root;
        while (p != null) {
            if (p.key < key) p = p.right;
            else if (p.key > key) p = p.left;
            else return p.value;
        }
        return p;
    }

    public Object min(BSTNode p) {
        if (p == null) return null;
        while (p.left != null) p = p.left;
        return p.value;
    }

    public Object min() {
        return min(root);
    }


    //这样构造重载方法！！！
    public Object max() {
        return max(root);
    }

    public Object max(BSTNode p) {
        if (p == null) return null;
        while (p.right != null) p = p.right;
        return p.value;
    }


    public void put(int key, Object value) {
        if (root == null) {
            root = new BSTNode(key, value);
            return;
        }
        BSTNode p = root;
        //用父节点记录父亲位置，方便更新
        BSTNode parent = p;
        while (p != null) {
            if (key == p.key) {
                p.value = value;
                return;
            }
            parent = p;
            if (key > p.key) p = p.right;
            else p = p.left;
        }
        if (key > parent.key) parent.right = new BSTNode(key, value);
        else parent.left = new BSTNode(key, value);
    }

    /*
     *       4
     *   2       7
     *1    3    6    8
     *         5
     * 前驱规则：如果有左子，那就选左子的最大，比如2467，直接找就行
     * 没有左子，则前驱是在左的祖先入358，这个用栈
     * */
    public Object predecessor(int key) {//前任
        BSTNode p = root;
        //来自左边的祖先指针：神来之笔
        BSTNode ancestorFromLeft = null;
        while (p != null && p.key != key) {
            if (key < p.key) p = p.left;
            else {
                //只有在向右走的时候才入栈，那么栈里面的肯定比p要小，栈顶就是其前驱（其实也不用栈）
                ancestorFromLeft = p;
                p = p.right;
            }
        }
        //找不到，根为空的时候p就是空，不要在前面就写了
        if (p == null) return null;
        //左子最大
        if (p.left != null) return max(p.left);
        //没有前驱返回为空
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    public Object successor(int key) {//后继，反过来的
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null && p.key != key) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else p = p.right;
        }
        if (p == null) return null;
        if (p.right != null) return min(p.right);
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    /*
        删除：只有单个孩子就抛给父亲
        没有直接删

     */
    public Object delete(int key) {
        BSTNode parent = null;
        BSTNode p = root;
        while (p != null && p.key != key) {
            parent = p;
            if (key > p.key) {
                p = p.right;
            } else {
                parent = p;
                p = p.left;
            }
        }
        //找不到数字，根为空的时候p就是空
        if (p == null) return root;
        if (p.right == null) shift(parent, p, p.left);
        else if (p.left == null) shift(parent, p, p.right);
        else {//左右都不为空
            /*
             *   删除需要后人（前任也可）代替，这里右孩子代替
             *   后人的两种位置
             *       4
             *   3          8
             *            7
             *         '5'
             *           6
             *
             *       5
             *   '2'
             *  1   3
             *        4
             * */
            BSTNode rightParent = null;
            BSTNode rightMin = p.right;
            while (rightMin.left != null) {
                rightParent = rightMin;
                rightMin = rightMin.left;
            }
            shift(parent, p, rightMin);
            rightMin.left = p.left;
            if (rightParent != null) {
                rightParent.left = rightMin.right;
                rightMin.right = p.right;
            }
        }
        return p.value;
    }

    //托孤方法
    public void shift(BSTNode parent, BSTNode deleted, BSTNode son) {
        //父节点为空，就把孩子成为根节点
        if (parent == null) root = son;
        //这里要是儿子才行，不能写null！
        else if (parent.right == deleted) parent.right = son;
        else parent.left = son;
    }

    //递归实现，把要删除的节点的孩子返回给父亲，
    public void delete2(int key) {
        //要做赋值操作！
        root = doDelete(key, root);
    }

    private BSTNode doDelete(int key, BSTNode node) {
        if (node == null) return null;
        if (key > node.key) {
            node.right = doDelete(key, node.right);
            return node;
        }
        if (key < node.key) {
            node.left = doDelete(key, node.left);
            return node;
        }
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        //两个都不是空，这里用了一种更抽象的方法，把后继者的右边用递归，把右子树删除后继者的树给它
        BSTNode rightMin = node.right;
        while (rightMin.left != null) rightMin = rightMin.left;
        //这个必须要在前面，因为后继者被删除的时候是应该没有左子树的
        rightMin.right=doDelete(rightMin.key,node.right);
        rightMin.left = node.left;
        return rightMin;
    }


    public void sequenceTraversal() {
        if (root == null) return;
        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                BSTNode node = queue.pop();
                System.out.print(node.value);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }
    }
    //范围查询
    public List<Object> less(int key){
        ArrayList<Object> arrayList = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (!stack.isEmpty()||p!=null){
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                if (p.key<key)arrayList.add(p.value);
                else break;
                p=p.right;
            }
        }
        return arrayList;
    }
    public List<Object> greater(int key){
        ArrayList<Object> arrayList = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (!stack.isEmpty()||p!=null){
            if (p!=null){
                stack.push(p);
                p=p.right;
            }else {
                p=stack.pop();
                if (p.key>key)arrayList.add(p.value);
                else break;
                p=p.left;
            }
        }
        return arrayList;
    }
    public List<Object> between(int min,int max){
        ArrayList<Object> arrayList = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (!stack.isEmpty()||p!=null){
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                //无需break，不然会提前死掉
                if (p.key<max&&p.key>min)arrayList.add(p.value);
                p=p.right;
            }
        }
        return arrayList;
    }

}
