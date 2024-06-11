package demo23_DP;

import java.util.Arrays;

public class Solution1_62 {
    //最短路径=上+左
    //初始化第一行，第一列全1，这题动态规划都写脸上了
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);
        for (int i = 1; i < m; i++) dp[i][0]=1;
        for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) dp[i][j]=dp[i-1][j]+dp[i][j-1];
        return dp[m-1][n-1];
    }
    //优化，你自己是一行一行整的，那么最后你的dp也可以变成一维的
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i]=dp[i]+dp[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
