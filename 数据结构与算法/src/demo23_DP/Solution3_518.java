package demo23_DP;

/*
*   当前加（j-coin）的个数
*   也就是说没有这个硬币有多少种方法+减去一个该种硬币的量还有多少种做法
*   那减去两个硬币呢？后面会考虑到前面咯
*       0   1   2   3   4   5   6   7   8   9   10  11  12
* 1     1   1   1   1   1   1   1   1   1   1   1   1   1
* 2     1   1   2   2   3   3   4   4   5   5   6   6   7
* 3     1   1   2   3   4   5   7......
*
* 5：11111，11122，122，113，23
* 6：333，321，3111
*
*       0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
* 2     1   0   1   0   1   0   1   0   1   0   1   0   1   0   1   0
* 3     1   0   1   1   1   1   2   1   2
* 5
* */
public class Solution3_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int coin : coins) {
            for (int j = coin; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
