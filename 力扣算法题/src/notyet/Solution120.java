package notyet;

import java.util.Arrays;
import java.util.List;

public class Solution120 {
    /*
     * 0 0 0 0
     * 2 0 0 0
     * 5 6
     * 111013
     * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (List<Integer> integerList : triangle) {
            for (int i = integerList.size()-1; i >=0 ; i--) {
                dp[i]=integerList.get(i)+min(dp,i-1,i);
            }
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) min = Math.min(min,dp[i]);
        return min;
    }

    private int min(int[] dp, int i, int j) {
        if (i<0)return dp[j];
        return Math.min(dp[i],dp[j]);
    }
}
