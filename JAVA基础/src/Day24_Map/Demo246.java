package Day24_Map;

import java.util.HashMap;

/*
HashMap底层与hashMap不覆盖添加
内部类Node实现了Map里面的Entry接口
Node成员变量：
1.hash：通过键计算出hash值，只能被赋值一次
2.键（只能被赋值一次），值
3.Node<> next，记录下一个节点的位置


红黑树的话就换了一个节点内部类，叫TreeNode
继承于LinkedHashMap的Entry，这个Entry又继承与HashMap里面的Node
属性有父，左，右，red记录红黑。
由于继承，也有Node里面的变量


HashMap里面的成员变量：
table表示数组，数组里面去装Node对象
DEFAULT_INITIAL_CAPACITY 1 << 4（1*2^4）初始容量是16
DEFAULT_LOAD_FACTOR = 0.75f 扩容时机，数组容量超过数组的1/4就扩容
空参构造方法public HashMap()中只加载了扩容时机，传入别的参数可以设置初始容量与扩容时机



从开始添加第一个元素的时候public V put(K key, V value)开始创建数组
return putVal(hash(key), key, value, false, true);
第一个参数是hash(key)是键的hash值，具体如何运算不看（最终目的还是为了让哈希后的结果更均匀的分部，减少哈希碰撞，提升hashmap的运行效率）
第四个参数代表的是onlyifAbsent：表示当前数据是否保留，false则不保留，能够覆盖，true则是保留，不能够被覆盖


点开putVal：
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
方法中的成员变量：
参数tab：定义局部变量记录哈希表中数组的地址值，被赋值为table
（方法在栈中，原来的table变量定义在堆中，在这里是为了避免反复调用堆浪费时间）
参数：Node<K,V> p：临时变量，记录键值对象的地址值
n：当前数组长度。i:表示索引

加入第一个元素的时候：
if ((tab = table) == null || (n = tab.length) == 0)
n = (tab = resize()).length;
如果没有创建数组或者数组长度为0：就调用resize方法创建新数组（长度为16，加载因子为0.75），返回给tab，并且赋值数组长度给n

在resize方法中：定义了oldTable，oldCap，oldThr，
分别为数组，规模（数组长度），阈值（扩容时机），数组一开始为空时，执行下列代码：
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
                    threshold = newThr;
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        return newTab;

如果不是第一次添加数据，就会看数组中的元素是否达到扩容条件
如果达到了扩容条件：底层会把数组扩容*2，并把数据“全部转移”到新的哈希表中：（和ArrayList很像）
（链表和数组想要赋值到新数组里需要重新进行哈希运算）

再回到putVal方法中：
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
这里给i赋值了hash值，给p赋值了数组中这个哈希值对应的下标的元素
如果它是空，直接给这个数组中的元素赋值就可以了。
newNode方法就是创建新一个节点：方法体就一行，这里newNode的时候，next为空
return new Node<>(hash, key, value, next);

最后再执行：
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
modCount是与并发修改异常相关的，可以先不看
afterNodeInsertion(evict)与linkedHashmap有关，先不看
如果size自增后大于了阈值，才执行resize方法
最后返回空：表示当前没有覆盖任何元素




当数组不为空：键不重复，但是形成链表的情况：
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

前面两个条件都不会成立，这里的p被赋值给已经存在的节点，执行下列代码：
        else {
            //这里定义了一个节点和一个键
            Node<K,V> e; K k;
            //如果数组中键值对的哈希值是要加入的这个键值对的哈希值，这一段if不会执行
            if (p.hash == hash &&
                //数组中的键值对的键与要加入的这个键值对相等（一种是等于，另一种是equals方法）
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //判断是否为树节点，这里才加入第二个元素，这一段也不执行
            else if (p instanceof TreeNode)
                //把当前节点按照红黑树的规则添加到树当中
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                //真正执行的是这一段循环
                for (int binCount = 0; ; ++binCount) {
                    不断获取数组中某个元素的子节点，如果到了这个链表中的最后一个节点
                    if ((e = p.next) == null) {
                        //创建一个新的节点
                        p.next = newNode(hash, key, value, null);
                        //下面这个是判断长度（循环次数+1）是否大于等于8
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            //如果大于等于8，就会执行变成红黑树的方法，当然在里面也会继续判断数组长度是否大于64
                            treeifyBin(tab, hash);
                        break;
                    }
                    //如果在遍历链表的时候被相同哈希值，并且也是相同对象的逮到了，也会停下来，别遍历了
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    //把遍历的节点给下一个
                    p = e;
                }
            }

            //这里由于e被赋值为空不会执行
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        //到了最后，增加size，返回空
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;





当数组不为空：键重复，元素覆盖的情况：这里也是哈希碰撞的情况：加入有元素的数组的哪个链表中：
       else {
            Node<K,V> e; K k;
            //这里就是还没有遍历，第一个节点就被逮到是相同的键了，直接跳到后面的if判断
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //这里是在遍历的过程中被逮到是同一个键了，跳到后面的if判断
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }

            //这里是被覆盖的那个键
            if (e != null) { // existing mapping for key
                //取出值老的值
                V oldValue = e.value;
                //判断当前的键是否能被覆盖，这里因为传递进来的是可以被覆盖
                //所以第一个条件就满足了，这个时候就更新了被逮到的键对应的值
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                //返回被替代的老值
                return oldValue;
            }
        }
在HashMap中，默认是使用的Hash值来构建的红黑树，所以不需要实现comparable接口或者传递comparator对象
上面其实也没讲如何扩容，或者是说如何转换成tree，这里先不看咯，往后走，读TreeMap
*/
public class Demo246 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println("使用putIfAbsent，键重复不会被覆盖");
        //底层与put方法不同的就是传递的第三个参数是true
        System.out.println(hashMap.putIfAbsent("aaa", 1));
        System.out.println(hashMap.putIfAbsent("aaa", 2));
        System.out.println(hashMap.putIfAbsent("aaa", 3));
        System.out.println(hashMap);
    }
}
