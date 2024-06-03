package demo20_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo3_TopologicalSort {
    /*
    *   拓扑排序：按照下面的学习顺序排序
    * 网页基础  \   数据库 \
    * java基础 —— javaWeb——   spring —— 微服务——实战项目
    * 找到入度为0的顶点
    * */
    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring框架");
        Vertex v5 = new Vertex("微服务框架");
        Vertex v6 = new Vertex("数据库");
        Vertex v7 = new Vertex("实战项目");
        v1.edges= List.of(new Edge(v3));
        v2.edges= List.of(new Edge(v3));
        v3.edges= List.of(new Edge(v4));
        v4.edges= List.of(new Edge(v5));
        v5.edges= List.of(new Edge(v7));
        v6.edges= List.of(new Edge(v4));
        //空必须要有一个空集合，否则遍历会造成空指针情况
        v7.edges=List.of();
        List<Vertex> graph = new ArrayList<>(List.of(v1,v2,v3,v4,v5,v6,v7));
        //统计顶点的入度数，在顶点类里面加属性
        for (Vertex vertex : graph) {
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree++;
            }
        }
        //将入度为0的顶点加入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph) {
            if (vertex.inDegree==0)queue.offer(vertex);
        }
        //队列移除顶点，需要指向节点的入度减去1，同时入度减为0的顶点在这里加入
        while (!queue.isEmpty()){
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (--edge.linked.inDegree==0){
                    queue.offer(edge.linked);
                }
            }
        }
    }


    //不能存在环，否则无法进行拓扑排序：有顶点的入度不会为0，也就是不会入队列
    /*
     * 网页基础  \   数据库 \
     * java基础 —— javaWeb——spring —— 微服务<——>实战项目
     * 检测的话看数量相等不相等即可
    * */
}
