package demo17_BTree;

import java.util.Arrays;

/*
 * 红黑适合做磁盘的数据管理，适合与内存
 * 阶是最大孩子个数
 * =B树宽很多，层少，叶子都在同一层，不会有特别的高出来的
 * 每个非叶子节点由n个关键字和n+1个指针组成
 * B+树的数据存放在叶子节点中，方便扫库
 * b要中序号遍历，B+就能从头开始，B+也更有利于区间查
 * B*就是非叶子节点多了指兄弟的指针。
 * */
public class BTree {
    static class Node {
        int[] keys;//多个关键字
        Node[] children;//孩子
        //有效关键字数组
        int keyNumber;
        //是否叶子
        boolean leaf;
        //最小度
        int t;

        //最小孩子数目
        public Node(int t) {
            this.t = t;
            //约定：最小度*2为最多度
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        //多路查找，定义在内部类里
        Node get(int key) {
            int i = 0;
            for (; i < keyNumber; i++) {
                if (keys[i] == key) return this;
                if (keys[i] > key) break;
            }
            if (leaf) return null;
            //在第i个孩子里面查找，刚好在超过的时候能够到达最后一个节点
            return children[i].get(key);
        }

        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        //注意keyNumber加在哪个涵数
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNumber - index);
            children[index] = child;
        }

        //工具方法：为了删除操作服务
        // 移除指定 index 处的 key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --keyNumber - index);
            return t;
        }

        int removeLeftmostKey() {
            return removeKey(0);
        }

        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        // 移除指定 index 处的 child，这里不用动key
        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber - index);
            children[keyNumber] = null; // help GC
            return t;
        }

        Node removeLeftmostChild() {
            return removeChild(0);
        }

        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        Node childLeftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        Node childRightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }

        // 复制当前节点的所有 key 和 child 到 target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            if (!leaf) for (int i = 0; i <= keyNumber; i++) {target.children[start + i] = children[i];}
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }
    }

    Node root;

    int t;//节点最小度数，每个节点度由此决定
    final int MIN_KEY_NUMBER;
    final int MAX_KEY_NUMBER;

    //在构造方法中使用别的构造方法
    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MIN_KEY_NUMBER = t - 1;
        MAX_KEY_NUMBER = 2 * t - 1;
    }

    //判断树中有无此节点
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    //新增
    public void put(int key) {
        doPut(root, key, 0, null);
    }

    private void doPut(Node node, int key, int index, Node parent) {
        int i = 0;
        for (; i < node.keyNumber; i++) {
            if (node.keys[i] == key) return;
            if (key > node.keys[i]) break;
        }
        if (node.leaf) node.insertKey(key, i);
            //非叶子节点找孩子插入，只能在叶子节点插入
        else doPut(node.children[i], key, i, node);
        //如果到达最大keyNumber，就要分裂
        //大一半的是t及以后的节点
        //中间的节点下标是t-1，把这个移动到上面，下标由该节点在上一层的孩子下标决定
        //新节点到老节点index+1的地方，而不是在最右边

        //分裂，参怎么填呢？这个函数多加参咯
        if (node.keyNumber == MAX_KEY_NUMBER) split(node, index, parent);
    }

    //index代表是第几个孩子（0开始），这里没有做空间清理操作
    private void split(Node left, int index, Node parent) {
        if (left == root) {//分裂根节点
            root = new Node(t);
            root.leaf = false;
            root.insertChild(left, 0);
            parent = root;
        }
        //初始化right
        Node right = new Node(t);
        //分裂节点是否是叶子要和老的一样，毕竟在同一层
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        //非叶子要多拷贝孩子，右边全部拷贝
        if (!right.leaf) System.arraycopy(left.children, t, right.children, 0, t);
        right.keyNumber = t - 1;
        left.keyNumber = right.keyNumber;
        //中间的key给到父节点，right孩子给到父节点
        parent.insertKey(left.keys[t - 1], index);
        parent.insertChild(right, index + 1);
    }

    // 3. 删除

    /**
     * 1.叶子节点：没找到，不找了
     * 2.叶子节点找到了，直接删除。
     * 3.非叶子节点没找到则向下
     * 4.非叶子节点找到了，找替死鬼交换然后删除
     * 对于平衡：删除后key小于Min，则要平衡处理（根节点除外）
     * 比较妙的是，叶子节点始终为叶子节点
     */
    public void remove(int key) {
        doRemove(null, root, 0, key);
    }

    private void doRemove(Node parent, Node node, int index, int key) {
        int i = 0;
        while (i < node.keyNumber) {
            //找到，或者大于就停
            if (node.keys[i] >= key)break;
            i++;
        }
        // i 找到，删除 key 的索引
        // i 没找到，到第i个孩子继续查找
        if (node.leaf) {
            if (!found(node, key, i))return;
            else node.removeKey(i);
        } else {
            if (!found(node, key, i)) {
                doRemove(node, node.children[i], i, key);
            } else {
                // 1. 找到后继背锅人，这里的后继就是后面一个孩子的最前面的孩子
                Node s = node.children[i + 1];
                while (!s.leaf) s = s.children[0];
                int skey = s.keys[0];
                // 2.祖先用后继
                node.keys[i] = skey;
                // 3. 再次让其成叶子节点删除后继skey即可。
                doRemove(node, node.children[i + 1], i + 1, skey);
            }
        }
        if (node.keyNumber < MIN_KEY_NUMBER) {
            // 调整平衡
            balance(parent, node, index);
        }
    }

    //前面条件避免越界
    private boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }

    /*
    * 平衡：旋转
    *       4
    *  123     56
    * 当bro有富余就能用吸吸大法：
    *       3
    * 12        45
    *
    * 当bro没有富余（此刻最小度：3，最大key数量：5）
    *       3
    * 12        4
    * 合并：
    *        删除
    *     1234
    *
    *       2
    * 1             34
    * 合并：
    *       删除
    *      1234
    * */
    private void balance(Node parent, Node x, int i) {
        // case 6 根节点
        if (x == root) {
            //根节点没有key了
            if (root.keyNumber == 0 && root.children[0] != null) root = root.children[0];
            return;
        }
        Node left = parent.childLeftSibling(i);
        Node right = parent.childRightSibling(i);
        //左边富裕，右旋
        if (left != null && left.keyNumber > MIN_KEY_NUMBER) {
            // 右旋要找父节点中前驱key，插入到前面
            x.insertKey(parent.keys[i - 1], 0);
            // 非叶子节点的时候：left中最大的孩子爹没了，给被资助的那个节点走
            //这里对应平衡父节点的情况，如果父节点有向下合并的情况，遍历来这里就不平衡了
            if (!left.leaf) x.insertChild(left.removeRightmostChild(), 0);
            //  left中最大的key旋转上去
            parent.keys[i - 1] = left.removeRightmostKey();
            return;
        }
        //右边富裕，左旋
        if (right != null && right.keyNumber > MIN_KEY_NUMBER) {
            //父节点中后继key旋转下来
            x.insertKey(parent.keys[i], x.keyNumber);
            if (!right.leaf) x.insertChild(right.removeLeftmostChild(), x.keyNumber);
            // right中最小的key旋转上去
            parent.keys[i] = right.removeLeftmostKey();
            return;
        }
        //两边都不够借，向左合并，右也可以
        if (left != null) {//有左，向左兄弟合并
            parent.removeChild(i);
            left.insertKey(parent.removeKey(i - 1), left.keyNumber);
            x.moveToTarget(left);
        } else {// 没有左，向自己合并
            parent.removeChild(i + 1);
            x.insertKey(parent.removeKey(i), x.keyNumber);
            right.moveToTarget(x);
        }
    }


    public void travel() {
        doTravel(root);
    }

    public void doTravel(Node node) {
        if (node == null) return;
        int i = 0;
        for (; i < node.keyNumber; i++) {
            doTravel(node.children[i]);
            System.out.println(node.keys[i]);
        }
        doTravel(node.children[i]);
    }
}
