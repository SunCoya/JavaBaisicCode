package demo23_DP;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//相较于之前的贝尔曼，前面的是存在对象属性当中的，这里就存在dp数组当中
public class Demo02_BellmanFord {
    static class Edge {
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
                new Edge(6, 5, 9),
                new Edge(4, 5, 6),
                new Edge(1, 6, 14),
                new Edge(3, 6, 2),
                new Edge(3, 4, 11),
                new Edge(2, 4, 15),
                new Edge(1, 3, 9),
                new Edge(1, 2, 7)
        );
        /*
         * 动态规划求解贝尔曼福德最短路径算法
         * f(v)代表从起点出发，到V的最短距离
         * f(v)=0/无穷大（V为起点和非起点）
         * f(to) = min(f(to),f(from)+f(from).weight)
         * 见img
         * f(v4) = min(无穷大，f(v3)+11)=20
         * f(v4) = min(20,f(v2)+15)=10
         * */
        //缓存这个点到起点的距离，六个顶点，这里从1开始判断
        int[] dp = new int[7];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;
        print(dp);
        //六个顶点要至多5轮操作
        for (int i = 0; i < 5; i++) {
            for (Edge edge : edges) {
                if (dp[edge.from] != Integer.MAX_VALUE)
                    dp[edge.to] = Math.min(dp[edge.from] + edge.weight, dp[edge.to]);
            }
            print(dp);
        }
    }
    static void print(int[] dp){
        System.out.println(Arrays.stream(dp)
                .mapToObj(i -> i == Integer.MAX_VALUE ? "∞" : String.valueOf(i))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
