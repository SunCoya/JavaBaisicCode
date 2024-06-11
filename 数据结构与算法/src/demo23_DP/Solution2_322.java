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
* 不正常，变-1：
*       0   1   2   3   4   5   6   7   8   9   10  11
* 2     0   -1  1   -1  2   -1  3   -1  4   -1  5   -1
* 5     0   -1  1   -1  2   1   3   2   4   3   2
* */
public class Solution2_322 {
    //12ms，87% 现在优化的想法就把amount减少
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE>>>1);
        dp[0]=0;
        for (int j = 0; j < dp.length; j++) {
            int coin = coins[0];//能整除
            if (j>=coin&&j%coin==0)dp[j]=j/coin;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                int coin = coins[i];
                //不用-1，用这个，能用就可以改
                if (j>=coin){dp[j]=Math.min(dp[j],dp[j-coin]+1);}
            }
        }
        if(dp[amount]==Integer.MAX_VALUE>>>1)return -1;
        else return dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1,2,5},11);
    }
}
