package demo20_graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 迪克斯特拉：单源最短路径，见本包图
 * 算法描述：
 * 创建一个集合存所有顶点
 * 初始地点为0，其余都是无穷大
 * 每次选择最小距离做当前顶点，遍历它的所有后继点，更新最小值
 * <p>
 * 在顶点类加一个距离的属性，方便记录最小值
 */
public class Demo4_Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);
        dijkstra(graph, v1);
    }

    //如何记录路径呢？在跟新节点的时候记录一下，更新节点属性
    private static void dijkstra(List<Vertex> graph, Vertex v1) {
        //未访问顶点集合，用优先级队列，方便找出最小
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        v1.dist = 0;
        for (Vertex vertex : graph) minHeap.offer(vertex);
        while (!minHeap.isEmpty()) {
            Vertex v = minHeap.peek();
            for (Edge edge : v.edges) {
                Vertex n = edge.linked;
                //加判断的代码段可以避免环
                if (!v.visited) {
                    int dist = edge.weight + v.dist;
                    if (dist < n.dist) {
                        n.dist = dist;
                        n.prev = v;
                        //重新加入队列，不然不会重新排列！！！
                        minHeap.remove(n);
                        minHeap.offer(n);
                    }
                }
            }
            v.visited = true;
            minHeap.poll();
        }
        for (Vertex vertex : graph)
            System.out.println(vertex.name + " " + vertex.dist + " " + (vertex.prev != null ? vertex.prev.name : "null"));
    }
}
