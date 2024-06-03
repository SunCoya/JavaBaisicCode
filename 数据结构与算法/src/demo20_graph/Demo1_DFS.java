package demo20_graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 深度优先：depth-first-search
 */
public class Demo1_DFS {
    public static void dfs (Vertex v){
        v.visited=true;
        System.out.println(v.name);
        for (Edge edge : v.edges) {
            if (!edge.linked.visited)dfs(edge.linked);
        }
    }
    //用栈，只是顺序与递归方式是反的，不过图的遍历哪有这么多讲究呢，又不是左右子树（
    public static void dfs2 (Vertex v){
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()){
            Vertex pop = stack.pop();
            pop.visited=true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited)stack.push(edge.linked);
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
        dfs(a);
    }
}
