package competition.W24511;

public class Solution1 {
    public boolean satisfiesConditions(int[][] grid) {
        //先判断竖着的
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0;i<grid.length-1;i++){
                if (grid[i][j]!=grid[i+1][j])return false;
            }
        }
        //再判断横着的
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length-1; j++) {
                if (grid[i][j]==grid[i][j+1])return false;
            }
        }
        return true;
    }

}
