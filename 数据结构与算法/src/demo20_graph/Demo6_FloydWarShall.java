package demo20_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//多源最短路径，其实也是一种动态规划思想，不能处理负环
//这里我只会方法，但是具体为什么能够成功，这个需要额外花时间
/*
*       >4    A  -2\
*    /              >
*   B      3 ->        C
*     <             /
*       \-1  D  2<
* 第一次
*     A  B  C  D
* A   0  ？-2  ？
* B   4  0  3  ？
* C   ？ ？ 0  2
* D   ？ -1 ？ 0
*
* 第二次，不看A那一行，看后面的行
*     A  B  C  D
* A   0  ？-2  ？
* B   4  0  2  ？
* C   ？ ？ 0  2
* D   ？ -1 ？ 0
*   借助B行
*     A  B  C  D
* A   0  ？-2  ？
* B   4  0  2  ？
* C   ？ ？ 0  2
* D   3 -1  1  0
*   借助C行
*     A  B  C  D
* A   0  ？-2  0
* B   4  0  2  4
* C   ？ ？ 0  2
* D   3 -1  1  0
*   借助D行
*     A  B  C  D
* A   0  -1 -2 0
* B   4  0  2  4
* C   5  1  0  2
* D   3 -1  1  0
 */
public class Demo6_FloydWarShall {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v1.edges = List.of(new Edge(v3, -2));
        v2.edges = List.of(new Edge(v3, 3),new Edge(v1,4));
        v3.edges = List.of(new Edge(v4, 2));
        v4.edges = List.of(new Edge(v2,-1));
        List<Vertex> list = List.of(v1,v2,v3,v4);
        floydWarShall(list);
    }
    private static void floydWarShall(List<Vertex> list) {
        int size = list.size();
        //如果出现负环，那么自己到自己就能够成为负数，只要对角线上的值小于0就是出现了负环
        int[][]dist = new int[size][size];
        //记录路径，上面的值是从这个节点到目标节点的上一个值，这个比较难理解
        Vertex[][] prev = new Vertex[size][size];
        //初始化
        for (int i = 0; i < size; i++) {
            Vertex v = list.get(i);
            //这里变map需要重写hash
            Map<Vertex, Integer> map = v.edges.stream().collect(Collectors.toMap(edge -> edge.linked, edge -> edge.weight));
            for (int j = 0; j < size; j++) {
                Vertex u = list.get(j);
                if (i==j)dist[i][j]=0;
                else dist[i][j]= map.getOrDefault(u,Integer.MAX_VALUE);
                prev[i][j]=map.get(u)!=null?v:null;
            }
        }
        print(dist);
        print(prev);
        /*
          [ 0, ∞,-2, ∞]
          [ 4, 0, 3, ∞]
          [ ∞, ∞, 0, 2]
          [ ∞,-1, ∞, 0]
        * */
        for (int i = 0; i < size; i++) {
            //第i层作为参考
            for (int j = 0; j < size; j++) {
                //第j层
                if (j==i||dist[j][i]==Integer.MAX_VALUE)continue;
                //从该顶点到参考顶点的距离
                int num = dist[j][i];
                for (int k = 0; k < size; k++) {
                    //第j层中的元素遍历
                    if (k==j||k==i)continue;
                    if (dist[i][k]!=Integer.MAX_VALUE){
                        int newNum = dist[i][k]+num;
                        if (newNum<dist[j][k]){
                            dist[j][k]=newNum;
                            //借助i到k
                            prev[j][k]=prev[i][k];
                        }
                    }
                }
            }
        }
        print(dist);
        print(prev);
        //打印路径
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path(prev,list,i,j);
            }
        }

    }

    private static void print(int[][] dist) {
        System.out.println(".....................................");
        for (int[] ints : dist) {
            System.out.println(Arrays.stream(ints).boxed()
                    .map(x->x==Integer.MAX_VALUE?"∞":String.valueOf(x))
                    //增加元素之间的间距
                    .map(s->String.format("%2s",s))
                    .collect(Collectors.joining(",","[","]")));
        }
    }
    private static void print(Vertex[][] prev) {
        System.out.println(".....................................");
        for (Vertex[] row:prev) {
            System.out.println(Arrays.stream(row)
                    .map(vertex -> vertex==null?"null": vertex.name)
                    //增加元素之间的间距
                    .map(s->String.format("%3s",s))
                    .collect(Collectors.joining(",","[","]")));
        }
    }

    //打印路径
    static  void path(Vertex[][] prev,List<Vertex> graph,int i,int j){
        System.out.print(graph.get(i).name+"->"+graph.get(j).name+":");
        LinkedList<String> stack = new LinkedList<>();
        stack.push(graph.get(j).name);
        while (i!=j){
            //目标的前一个
            Vertex p =prev[i][j];
            //压栈
            stack.push(p.name);
            //j变成目标的前一个
            j=graph.indexOf(p);
        }
        //栈的顺序即为从开始到结束的位置（因为是从后逐步往前推的）
        System.out.println(stack);
    }
}
