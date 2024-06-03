package demo20_graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先遍历，使用队列，注意在加入队列的时候改访问状态
 */
public class Demo2_BFS {
    public static void bfs(Vertex v){
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(v);
        v.visited=true;
        while (!queue.isEmpty()){
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited){
                    edge.linked.visited=true;
                    queue.offer(edge.linked);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        a.edges= List.of(new Edge(b),new Edge(c));
        b.edges=List.of(new Edge(d));
        c.edges=List.of(new Edge(d));
        d.edges=List.of();
        bfs(a);
    }
}
