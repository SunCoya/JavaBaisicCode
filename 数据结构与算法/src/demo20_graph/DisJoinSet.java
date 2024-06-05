package demo20_graph;

import java.util.Arrays;

//不相交集合（并Unit查Find集合）
public class DisJoinSet {
    int[] s;
    int[] size;

    //初始化，存放图中的每一个节点
    //一开始表示只和自己有关系
    public DisJoinSet(int size) {
        this.s = new int[size];
        //size初始化为1，记录元素个数，也就代表着这个集的规模（老大手下有多少人）
        this.size = new int[size];
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
        //如果两个顶点有关系，比如01，就能把0索引改为1
        //比如23，就能把2索引改为3
        //连接01和23，就要改索引没变的，比如01里面找1，23里面找3
        //union不代表连线，这也是代表集合的一种方式，（不用创建多个链表什么的）

    }

    public int find(int x) {
        if (x == s[x]) return x;
        //优化1赋值递归，找到老大后也跟新
        return s[x] = find(s[x]);
    }

    public void union(int x, int y) {

        //这两步是找老大
        y = find(y);
        x = find(x);

        //优化2，连接一个节点与一个老大，肯定是把单节点上面的值改成老大的，需要新数组记录个数，UnionBySize
        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        //相等就直接走咯
        if (s[y] == x) return;
        s[y] = x;
        //只管加，反正最后都会加到老大上面
        size[x] += size[y];
    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }

    public static void main(String[] args) {
        DisJoinSet set = new DisJoinSet(7);
        System.out.println(set);
        //连03
        set.union(0, 3);
        System.out.println(set);
        //连56
        set.union(5, 6);
        System.out.println(set);
        //连01
        set.union(0, 1);
        System.out.println(set);
        //连23
        set.union(2, 3);
        System.out.println(set);

        System.out.println();

        //连02
        set.union(0, 2);
        System.out.println(set);
        //连36
        set.union(3, 6);
        System.out.println(set);
        set.union(4, 6);
        System.out.println(set);
        System.out.println(Arrays.toString(set.size));
    }
    //比较糟糕的情况就是找老大的路很长找6的老大可能要6543210
}
