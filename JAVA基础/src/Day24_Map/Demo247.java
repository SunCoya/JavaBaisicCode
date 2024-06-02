package Day24_Map;

import java.util.TreeMap;
/*
TreeMap属性：comparator，root（根节点），size
空参构造只是把比较器赋值了NULL
带参构造就是传进去比较器，赋值给自己的比较器
在treemap中，entry继承于Map里面的entry
属性：键、值、左、右、父、颜色。在Java中给颜色设置了true false，提高了阅读性
在put方法中：调用三个参数的put方法，第三个参数代表代替老元素
    public V put(K key, V value) {
        return put(key, value, true);
    }
在第二个put里面：执行下列代码：创建新的节点，返回为空
        //t为根节点的地址值
        Entry<K,V> t = root;
        if (t == null) {
            addEntryToEmptyMap(key, value);
            return null;
        }
   private void addEntryToEmptyMap(K key, V value) {
        compare(key, key); // type  (and possibly null) check
        root = new Entry<>(key, value, null);
        size = 1;
        modCount++;
    }
创建第二个节点时：
        //两个键比较的结果
        int cmp;
        //当前添加节点的父节点
        Entry<K,V> parent;
        记录比较器，分有比较器和无比较器两条不同路径（其实两种情况都差不多，不同的地方只有一点点）
        Comparator<? super K> cpr = comparator;
        //传递了比较器进来
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        //没有传递比较器进来
        } else {
            Objects.requireNonNull(key);
            //这里传递一个比较规则（在Key的类或者其子类里面写的）
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
            //这里的循环是找父节点（parent）和与父节点的大小比较（cmp）
            do {
                //先把根节点当作当前节点的父节点
                parent = t;
                比较两个键的结果，拿当前节点和根节点比较
                cmp = k.compareTo(t.key);
                //根据比较结果到根节点的左右找
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else {
                //用新值代替老值，返回被替代的老值
                    V oldValue = t.value;
                    if (replaceOld || oldValue == null) {
                        t.value = value;
                    }
                    return oldValue;
                }
            } while (t != null);
        }
        addEntry(key, value, parent, cmp < 0);
        return null;

在addEntry方法中：添加节点指定父节点，父节点指定孩子
    private void addEntry(K key, V value, Entry<K, V> parent, boolean addToLeft) {
        //new一个新节点，把父节点的left记录为当前节点
        Entry<K,V> e = new Entry<>(key, value, parent);
        if (addToLeft)
            parent.left = e;
        else
            parent.right = e;
        //添加完节点之后的调整：红黑规则
        fixAfterInsertion(e);
        size++;
        modCount++;
    }

在这个方法中满足红黑规则
        private void fixAfterInsertion(Entry<K,V> x) {
        //第一步就先设置了添加的节点为红色
        x.color = RED;
        //X为当前要添加的节点，节点不为空，不是根节点，父节点是红
        while (x != null && x != root && x.parent.color == RED) {
            //以下的父节点全是红色

            //自己的父亲是爷爷的左孩子：这样就知道了叔叔是右孩子
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                //获取叔叔
                Entry<K,V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    //叔叔节点为红色，叔叔父亲全部变黑，爷爷变红，再把当前节点变为爷爷
                    //注意到外层的大循环：爷爷要是一个根节点才能停下来哦。
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    //叔叔节点黑色，父亲节点红色，先看自己是不是右节点，如果是，那就左旋父亲
                    if (x == rightOf(parentOf(x))) {
                    //左旋之后父子身份交换（他们两个都是红）
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    //把父亲变为黑色，爷爷变成红色，右旋爷爷（让分布变得更加均匀）
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            //自己的父亲是爷爷的右孩子：这样就知道了叔叔是左孩子
            } else {
                Entry<K,V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        //不管怎么样，最后都得把祖父设置为黑色
        root.color = BLACK;
    }

再多看看旋转源码（左旋）：
    private void rotateLeft(Entry<K,V> p) {
         p为要左旋转的节点
        if (p != null) {
            //设置r为当旋转节点的右孩子，r为上位者，p为下位者
            //上位者需要把左孩子给下位者当作右孩子
            Entry<K,V> r = p.right;
            //下面是交换孩子环节，父亲认孩子
            //旋转节点右孩子的左孩子 给 旋转节点右孩子
            p.right = r.left;
            //下面是孩子认父亲环节
            //如果当  旋转节点右孩子的左孩子  不为空  就设置它的父母为旋转节点，到这里就完成了孩子交换
            if (r.left != null)
                r.left.parent = p;

            //下面是父亲认爷爷环节
            //把旋转节点的父母 给旋转节点的右孩子的父母
            r.parent = p.parent;
            //如果旋转节点没父母，就设置旋转节点右孩子为根节点
            if (p.parent == null)
                root = r;
            //下面是爷爷认父亲环节
            //如果旋转节是左孩子
            else if (p.parent.left == p)
                p.parent.left = r;
            else
            //旋转节点是右孩子
                p.parent.right = r;

            //最后完成身份交换
            r.left = p;
            p.parent = r;
        }
    }
*/
public class Demo247 {
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>();
    }
}
