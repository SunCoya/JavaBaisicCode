package demo16_balancedBinarySearchTree;

/*
 * 红黑树不追求"完全平衡"，、 即不像AVL那样要求节点的 |balFact| <= 1， 它只要求部分达到平衡
 * 但是提出了为节点增加颜色，红黑是用非严格的平衡来换取增删节点时候旋转次数的降低，任何不平衡都会在三次旋转之内解决
 * 而AVL是严格平衡树，因此在增加或者删除节点的时候，根据不同情况，旋转的次数比红黑树要多
 * 红黑树：也是一种自平衡的二叉搜索树，插入和删除所需要的旋转次数更少
 * 红黑特性
 * 1所有null都是黑色
 * 2红色节点不相邻
 * 3根节点是黑色
 * 4从根节点到任意叶子节点，黑色节点数量要一样
 *
 *               6
 *           2       8
 *       1*
 *      平衡的二叉树
 *
 *               6
 *           2*      8
 *       1
 *       不平衡的二叉树，null也算黑色节点
 *   也就是说，叶子节点没有兄弟就不行，黑色的节点必须要有兄弟
 *      好难哦
 * */
public class RedBlackTree {
    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        //多了父和颜色，少了高
        Node parent;
        //颜色默认为红色
        Color color = Color.RED;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        //工具方法
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        Node uncle() {
            if (parent == null || parent.parent == null) return null;
            //如果是左孩子返回右
            if (parent.isLeftChild()) return parent.parent.right;
            else return parent.parent.left;
        }

        Node sibling() {
            if (parent == null) return null;
            if (this.isLeftChild()) return parent.right;
            else return parent.left;
        }
    }

    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    //空也是null
    boolean isBlack(Node node) {
        return !isRed(node);
    }

    //相对平衡二叉搜索树1.没有返回值2.parent要处理
    private void rightRotate(Node node) {
        //更上层的也要往下指
        Node parent = node.parent;
        //左孩子，即为后面的上位
        Node left = node.left;
        //左孩子的右孩子
        Node leftRight = left.right;
        //指新父亲
        if (parent == null) root = left;
        else if (node.isLeftChild()) parent.left = left;
        else parent.right = left;
        left.right = node;
        left.parent = parent;
        node.parent = left;
        node.left = leftRight;
        if (leftRight != null) leftRight.parent = node;
    }

    private void leftRotate(Node node) {
        Node parent = node.parent;
        Node right = node.right;
        Node rightLeft = right.left;
        if (parent == null) root = rightLeft;
        else if (node.isLeftChild()) parent.left = right;
        else parent.right = right;
        right.left = node;
        right.parent = parent;
        node.parent = right;
        node.right = rightLeft;
        if (rightLeft != null) rightLeft.parent = node;
    }

    //遇到红红不平衡则要调整
    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) p = p.left;
            else if (key > p.key) p = p.right;
            else {
                p.value = value;
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key > parent.key) {
            parent.right = inserted;
        } else {
            parent.left = inserted;
        }
        inserted.parent = parent;
        fixRedRed(inserted);
    }


    //相邻两个红色就要修改
    void fixRedRed(Node node) {
        if (node == root) {
            node.color = Color.BLACK;
            return;
        }
        if (isBlack(node.parent)) return;
        Node parent = node.parent;
        Node uncle = node.uncle();
        Node grandpa = parent.parent;
        if (isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandpa.color = Color.RED;
            fixRedRed(grandpa);
            return;
        }
        //父红叔黑：父黑爷红，转
        grandpa.color = Color.RED;

        if (node.isLeftChild() && parent.isLeftChild()) {
            parent.color = Color.BLACK;
            rightRotate(grandpa);
        } else if (!node.isLeftChild() && !parent.isLeftChild()) {
            parent.color = Color.BLACK;
            leftRotate(grandpa);
        } else if (node.isLeftChild()) {
            node.color = Color.BLACK;
            rightRotate(parent);
            leftRotate(grandpa);
        } else {
            node.color = Color.BLACK;
            leftRotate(parent);
            rightRotate(grandpa);
        }
    }

    //找到删除的节点
    Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key > p.key) p = p.right;
            else if (key < p.key) p = p.left;
            else break;
        }
        return p;
    }

    Node findReplaced(Node deleted) {
        if (deleted.left == null && deleted.right == null) return null;
        else if (deleted.right == null) return deleted.left;
        else if (deleted.left == null) return deleted.right;
        else {
            Node rightMin = deleted.right;
            while (rightMin.left != null) rightMin = rightMin.left;
            return rightMin;
        }
    }


    //删除：李代桃僵法：删除某个节点等于删除它的后继节点
    //也就是说原来应该被删除的东西于它后继节点交换，一直一直往下，直到为根节点
    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) return;
        doRemove(deleted);
    }

    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        if (replaced == null) {//没有孩子
            if (deleted == root) root = null;
            else {
                //删除的是黑色叶子（需要复杂处理），红色叶子不需要处理
                //先做平衡调整，再删除
                if (isBlack(deleted)) fixDoubleBlack(deleted);
                if (deleted.isLeftChild()) parent.left = null;
                else parent.right = null;
                //垃圾回收
                deleted.parent = null;
            }

        } else if (deleted.left == null || deleted.right == null) {//一个孩子
            //删除的是根且只有一个孩子
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                //清空左右孩子
                root.left = root.right = null;
            } else {
                //有孩子情况，需要思考单个孩子的情况下，单孩子最高多少呢？最高一层
                if (deleted.isLeftChild()) parent.left = replaced;
                else parent.right = replaced;
                replaced.parent = parent;
                //垃圾回收
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replaced)) {
                    //复杂处理，先删掉再调整平衡
                    fixDoubleBlack(replaced);
                } else {
                    //删除的是黑色但是剩下的是红色
                    replaced.color = Color.BLACK;
                }
            }
        } else {//两个孩子——>转换成一个孩子或者没有孩子的节点
            int t = deleted.key;
            deleted.key = replaced.key;
            replaced.key = t;
            Object o = deleted.value;
            deleted.value = replaced.value;
            replaced.value = o;
            doRemove(replaced);
        }
    }

    private void fixDoubleBlack(Node node) {
        //处理情况：删除的是黑色叶子，删除的和剩下的都是黑色的，也就是说少了一个黑色
        //如果删除的黑色节点兄弟是红色
        //树顶部停止
        if (node == root) return;
        Node parent = node.parent;
        Node sibling = node.sibling();
        if (isRed(sibling)) {
            //旋转
            if (node.isLeftChild()) leftRotate(parent);
            else rightRotate(parent);
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(node);
        } else {
            //红黑树里面有可能出现全黑情况
            //如果兄弟为黑，两个侄子为黑， 兄弟不可能是空
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                //如果爹是红色
                if (isRed(parent)) parent.color = Color.BLACK;
                else fixDoubleBlack(parent);
            } else {
                //兄弟黑色，侄子有红色的
                if (sibling.isLeftChild()&&isRed(sibling.left)){
                    rightRotate(parent);
                    //旋转上去的颜色要变得和父亲一样
                    sibling.color=parent.color;
                    sibling.left.color=Color.BLACK;
                }else if (sibling.isLeftChild()&&isRed(sibling.right)){
                    //变色应该在旋转之前
                    sibling.right.color=parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }else if (isRed(sibling.right)){
                    leftRotate(parent);
                    sibling.color=parent.color;
                    sibling.left.color=Color.BLACK;
                }else {
                    sibling.left.color=parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }
                parent.color=Color.BLACK;
            }
        }
    }
}
