package competition.W24511;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution2 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        //每一行第0位设置成有效坐标
        for (int i = 0; i < points.length; i++) points[i][0]=Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->a.index-b.index);
        for (int i = 0; i < s.length(); i++) queue.offer(new Node(s.charAt(i),points[i][0]));
        //初始化小顶堆
        int size=0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (!queue.isEmpty()){
            int sizeThis = 0;
            Node poll=queue.peek();
            while (!queue.isEmpty()&&queue.peek().index==poll.index){
                poll =  queue.poll();
                if (!hashMap.containsKey(poll.val))hashMap.put(poll.val,poll.index);
                else return size;
                sizeThis++;
            }
            size+=sizeThis;
        }
        return size;
    }
    static class Node{
        char val;
        int index;
        public Node(char val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    //返回的是坐标：最小的坐标
}
