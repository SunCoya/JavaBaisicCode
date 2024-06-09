package demo20_graph;

import java.util.List;

/*
 * Bellman——Ford算法
 * Dijkstra优缺点：有负数距离会影响
 * 如
 * A      1      C  1  D
 *     2  B  -2
 * 最短应该是ABCD但会判断A——C——D/B？
 *本算法思路是不动某一点，利用该点，求外顶点到别的点的距离
 * 但不能处理负的环，会越来越小
 * 该案例中可以在三轮循环过后，如果又进入判断，即存在负环
 * */
public class Demo5_Bellman {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = List.of(new Edge(v3, 1), new Edge(v2, 2));
        v2.edges = List.of(new Edge(v3, -2));
        v3.edges = List.of(new Edge(v4, 1));
        v4.edges = List.of();

        List<Vertex> graph = List.of(v1, v2, v3, v4);
        bellmanFord(graph,v1);
    }

    private static void bellmanFord(List<Vertex> graph, Vertex v1) {
        v1.dist=0;
        //四个顶点处理三次
        for (int i = 0; i < graph.size()-1; i++) {
            for (Vertex start : graph) {
                for (Edge edge : start.edges) {
                    Vertex end = edge.linked;
                    if (start.dist!=Integer.MAX_VALUE&&start.dist+ edge.weight< end.dist){
                        end.dist=start.dist+ edge.weight;
                        end.prev=start;
                    }
                }
            }
        }
        for (Vertex vertex : graph) {
            System.out.println(vertex.name+" "+vertex.dist+" "+(vertex.prev==null?"null":vertex.prev.name));
        }
    }
}
