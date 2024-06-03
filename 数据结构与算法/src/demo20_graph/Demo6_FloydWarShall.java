package demo20_graph;

import java.util.List;

//多源最短路径，其实也是一种动态规划思想，不能处理负环
/*
*       >4    A  -2\
*    /              >
*   B      3 ->        C
*     <             /
*       \-1  D  2<
* 第一次
*     A  B  C  D
* A   0  ？-2  ？
* B   4  0  3  ？
* C   ？ ？ 0  2
* D   ？ -1 ？ 0
*
* 第二次，不看A那一行，看后面的行
*
*
* */
public class Demo6_FloydWarShall {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v3, -2));
        v2.edges = List.of(new Edge(v3, 3),new Edge(v1,4));
        v3.edges = List.of(new Edge(v4, 2));
        v4.edges = List.of(new Edge(v2,-1));


    }
}
