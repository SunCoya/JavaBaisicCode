package demo20_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//逐一处理每条边来得到最小生成树
//连接最小的边，但是不连接多余边
//此包中狄克斯特拉（处理负边需要用贝尔曼），prim，克鲁斯克拉都是属于贪心策略
public class Demo8_Kruskal {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");
        List<Vertex> list = List.of(v1,v2,v3,v4,v5,v6,v7);
        PriorityQueue<Edge> queue = new PriorityQueue<>(List.of(
                new Edge(list,0,1,2),
                new Edge(list,0,2,4),
                new Edge(list,0,3,1),
                new Edge(list,1,3,3),
                new Edge(list,1,4,10),
                new Edge(list,2,3,2),
                new Edge(list,2,5,5),
                new Edge(list,3,4,7),
                new Edge(list,3,5,8),
                new Edge(list,3,6,4),
                new Edge(list,4,6,6),
                new Edge(list,5,6,1)
        ));
        kruskal(list.size(),queue);
    }

    private static void kruskal(int size, PriorityQueue<Edge> queue) {
        //存储结果
        List<Edge> list = new ArrayList<>();
        DisJoinSet set = new DisJoinSet(size);
        //招够六条边就停止循环，也就是顶点数量减一
        while (list.size()<size-1){
            Edge poll = queue.poll();
            int i = set.find(poll.start);
            int j = set.find(poll.end);
            if (i==j)continue;//是同一个顶点则跳过操作，不用连
            set.union(i,j);
            list.add(poll);
        }
        for (Edge edge : list) {
            System.out.println(edge.start+" "+edge.end);
        }
    }

    static class Edge implements Comparable<Edge>{
        List<Vertex> vertices;
        int start;
        int end;
        int weight;
        public Edge(List<Vertex> vertices, int start, int end, int weight) {
            this.vertices = vertices;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
}
