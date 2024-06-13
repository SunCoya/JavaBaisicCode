package demo23_DP;

import java.util.Arrays;

/*
* 硬币纵，总值横
* 正常：
*       0   1   2   3   4   5   6   7   8   9   10  11
* 1     0   1   2   3   4   5   6   7   8   9   10  11
* 2     0   1   1   2   2   3   3   4   4   5   5   6
* 5     0   1   1   2   2   1   2   2   3   3   2   3
*
* 不正常，变-1,这里变Integer.max>>>1
*       0   1   2   3   4   5   6   7   8   9   10  11
* 2     0   -1  1   -1  2   -1  3   -1  4   -1  5   -1
* 5     0   -1  1   -1  2   1   3   2   4   3   2   4
* */
public class Solution2_322 {
    //12ms，87% 现在优化的想法就把amount减少
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE>>>1);
        dp[0]=0;
        //这里可把第一行也放进去循环
        for (int i : coins) {
            //这里的j直接从coin开始循环就可以咯，前面的也不用动
            for (int j = i; j < amount + 1; j++) {
                //不用-1，用这个大的数，能用就可以改
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
           }
        }
        return dp[amount]==Integer.MAX_VALUE>>>1?-1:dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1,2,5},11);
    }
}
