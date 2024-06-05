package demo20_graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//最小生成树，在图里面找连接所有点的最短边，图在img2
//思路和狄克斯特拉很像，直接抄代码，把判断条件改为当前节点连接线的权重
//从一个顶点开始，每次处理最小dist的节点，并把邻居新，自己从表中删除，之后就处理剩下的节点
//这个思路不是把所有最短的边连起来！
public class Demo7_Prim {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        v1.edges= List.of(new Edge(v2,2),new Edge(v3,4),new Edge(v4,1));
        v2.edges= List.of(new Edge(v1,2),new Edge(v4,3),new Edge(v5,10));
        v3.edges= List.of(new Edge(v1,4),new Edge(v4,2),new Edge(v6,5));
        v4.edges= List.of(new Edge(v1,1),new Edge(v2,3),new Edge(v3,2),new Edge(v5,7),new Edge(v6,8),new Edge(v7,4));
        v5.edges= List.of(new Edge(v2,10),new Edge(v4,7),new Edge(v7,6));
        v6.edges= List.of(new Edge(v3,5),new Edge(v4,8),new Edge(v7,1));
        v7.edges= List.of(new Edge(v4,4),new Edge(v5,6),new Edge(v6,1));
        List<Vertex> graph = List.of(v1,v2,v2,v3,v4,v5,v6,v7);
        dijkstra(graph,v1);
    }
    private static void dijkstra(List<Vertex> graph, Vertex v1) {
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        v1.dist = 0;
        for (Vertex vertex : graph) minHeap.offer(vertex);
        while (!minHeap.isEmpty()) {
            Vertex v = minHeap.peek();
            for (Edge edge : v.edges) {
                Vertex n = edge.linked;
                //加判断的代码段可以避免环
                if (!v.visited) {
                    int dist = edge.weight;
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
        for (Vertex vertex : graph) {
            System.out.println(vertex.name+" "+vertex.dist+" "+(vertex.prev!=null?vertex.prev.name:"null"));
        }
    }
}
