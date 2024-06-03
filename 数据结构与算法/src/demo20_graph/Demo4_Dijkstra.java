package demo20_graph;

import java.util.List;

//迪克斯特拉：单源最短路径，见本包图
public class Demo4_Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges= List.of(new Edge(v3,9),new Edge(v2,7),new Edge(v6,14));
        v2.edges= List.of(new Edge(v4,15));
        v3.edges= List.of(new Edge(v4,11),new Edge(v6,2));
        v4.edges= List.of(new Edge(v5,6));
        v5.edges= List.of();
        v6.edges= List.of(new Edge(v5,9));

    }
}
