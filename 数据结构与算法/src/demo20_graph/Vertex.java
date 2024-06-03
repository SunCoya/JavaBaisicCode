package demo20_graph;

import java.util.List;

/*
* 图
* 无向图有向图，有向图单边
* 度是图的顶点（节点）的边的数量
* 有向图又有入度和出度
* 权重代表边的度量，费用，距离，时间等
* 图也能成环
* 所有的顶点都是连通的，则叫连通图（能够到达所有顶点）
* 子图联通则叫连通分量
*
* 对于图的表示：
* 邻接矩阵：就是二维数组,对称，缺点就是浪费空间，推荐邻接表
* A——B
* |  |
* C——D
*   ABCD
* A 0110
* B 1001
* C 1001
* D 0110
*
* 邻接表：一维数组加链表
* A->B->C
* B->A->D
* C->A->D
* D->B->C
* */
public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited;//是否访问过，用在深度与广度遍历
    int inDegree;//入度，用在拓扑排序
    int status;//状态，0未访问，1正在防蚊重，2已经访问过（用于环的检测），用在拓扑排序（深度遍历）


    //距离，用于单源最短路径算法
    int dist = Integer.MAX_VALUE;

    Vertex prev=null;//记录路径，跟新最短路径的时候指向前一个节点，为什么不指向后面的呢？一开始就算出了距离，如果选最短的就改不了

    public Vertex(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


}
