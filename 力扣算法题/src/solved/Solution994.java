package solved;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    //用数组+接口！不然容易混
    Queue<int[]> queue = new LinkedList<>();
    int[][] grid;
    //用count计数，一开始没有用，很折磨
    int count=0;
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) count++;
            }
        }
        int time = 0;
        //如果还有橘子。6嗷这个操作，刚好解决了我最后一步感染为空的情况
        while (count>0&&!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                change(i, j - 1);
                change(i - 1, j);
                change(i, j + 1);
                change(i + 1, j);
            }
            time++;
        }
        if (count>0)return -1;
        return time;
    }

    public void change(int i, int j) {
        if (!(i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[i].length - 1 && grid[i][j] == 1)) return;
        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        count--;
    }
}
