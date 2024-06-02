package demo16_balancedBinarySearchTree;

//自平衡的二叉搜索树名字是两个作者中间的字母，B树就是子平衡的树
public class AVLTree {
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;//来自力扣，为了记录高度差，这里很巧妙，最高处变动的时候底层人民不会受到伤害
        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
        public AVLNode(int key) {
            this.key = key;
        }
        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    AVLNode root = null;

    private int height(AVLNode node) {
        //为空则为0
        if (node == null) return 0;
        return node.height;
    }

    //在新增，删除，旋转的时候更新节点高度
    //高度是树越高，root高度越大
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //平衡因子：左子树高度减去右子树高度
    private int balanceFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    /*
     *   LL：
     *  左边高右边低有两种情况
     *  只右旋：左边高，左孩子的bf>=0
     *       5                   3
     *    3     6              2   5
     *  2  4         ->      1   4  6
     * 1
     *   右旋之后3上头，3抛弃右孩子给5作为左孩子
     *
     * LR：
     *   先左后右：左边高，左孩子的bf<0
     *       6                       6                       4
     *   2            7   ->      4      7       ->        2     6
     * 1     4                  2                        1  3      7
     *     3                   1 3
     * 如果像上一个右旋，那就变成右高左低了
     *
     * 还有RR和RL两种情况，相反的，不赘述
     * */

    //左右旋转操作，返回新的根节点
    public AVLNode rightRotate(AVLNode node) {
        AVLNode left = node.left;
        node.left = left.right;
        left.right = node;
        //上位的和下位的都要更新，上位更新情况看LR的情况：4上去了，但是把左孩子给了，高度变成3
        updateHeight(node);
        updateHeight(left);
        return left;
    }

    private AVLNode leftRotate(AVLNode node) {
        AVLNode right = node.right;
        node.right = right.left;
        right.left = node;
        updateHeight(node);
        updateHeight(right);
        return right;
    }


    private AVLNode rightLeftRotate(AVLNode node) {
        //要更新左孩子
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    private AVLNode leftRightRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }


    //考虑到删除情况，依然会有root不平衡但孩子左右平衡的情况
    /*
     *           6
     *     3             8
     *   1   4
     * 删除8之后左子树平衡，怎么办呢？右旋！（左右旋也可以。。）
     *
     * */
    private AVLNode balance(AVLNode node) {
        int factor = balanceFactor(node);
        if (factor > 1) {
            if (balanceFactor(node.left) >= 0) return leftRotate(node);
            return rightLeftRotate(node);
        }
        if (factor < -1) {
            if (balanceFactor(node.right) <= 0) return rightRotate(node);
            return leftRightRotate(node);
        }
        return node;
    }

    public void put(int key, Object value) {
        //非递归就不太好更新高度，因为不一定会增高，得用栈记录路径
        root = doPut(key, value, root);
    }

    private AVLNode doPut(int key, Object value, AVLNode node) {
        if (node == null) return new AVLNode(key, value);
        if (key == node.key) {
            node.value = value;
            return node;
        } else {
            if (key > node.key) node.right = doPut(key, value, node.right);
            else node.left = doPut(key, value, node.left);
        }
        updateHeight(node);
        //返回的是新的节点！
        return balance(node);
    }

    public void remove(int key) {
        root = doRemove(key, root);
    }

    //这段代码回去看了一下
    private AVLNode doRemove(int key, AVLNode node) {
        if (node == null) return null;
        if (key > node.key) node.right = doRemove(key, node.right);
        else if (key < node.key) node.right = doRemove(key, node.left);
            //左右孩子皆为空就不能赋值：updateheight方法里面没有写对空的处理，这里就多写一写
        else if (node.left == null && node.right == null) return null;
        else if (node.right == null) node = node.left;
        else if (node.left == null) node = node.right;
        else {
            AVLNode rightMin = node.right;
            while (rightMin.left != null) rightMin = rightMin.left;
            rightMin.right = doRemove(rightMin.key, node.right);
            rightMin.left = node.left;
            node = rightMin;
        }
        updateHeight(node);
        return balance(node);
    }
}
