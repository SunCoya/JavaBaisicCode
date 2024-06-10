package demo23_DP;

import java.util.List;

/*
* 动态规划求解贝尔曼福德最短路径算法
* f(v)代表从起点出发，到V的最短距离
* f(v)=0/无穷大（V为起点和非起点）
* f(to) = min(f(to),f(from)+f(from).weight)
* 见img
* f(v4) = min(无穷大，f(v3)+11)=20
* f(v4) = min(20,f(v2)+15)=10
*
* */
public class Demo02_BellmanFord {
    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = List.of(
                new Edge(6,5,9),
                new Edge(4,5,6),
                new Edge(1,6,14),
                new Edge(3,6,2),
                new Edge(3,4,11),
                new Edge(2,4,15),
                new Edge(1,3,9),
                new Edge(1,2,7)
        );
    }
}
