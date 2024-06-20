package demo23_DP;

import java.util.Arrays;

//最长公共子序列：字符之间不需要再一起
/*
 *       a   b   c   d   e
 * a     1   1   1   1   1
 * c     1   1   2   2   2
 * e     1   1   2   2   3
 *
 *       a   e   i   b   c   d   e
 * a     1   1   1   1   1   1   1
 * b     1   1   1   2   2   2   2
 * c     1   1   1   2   3   3   3
 * d     1   1   1   2   3   4   4
 * e     1   2   2   2   3   4   5
 *
 * 碰到相同，就看左上角+1！
 * 不同，max（前一个，这一个）
 * 是什么意思呢？当前这么长的字符串在与另一个串的最长公共子序列，注意是当前，比较难表述
 *
 *
 *错误一：第一个的处理：
 *       b   l
 * y     0   0
 * b     1   1
 * y     1   1
 *
 *错误二：碰到相同的应该？
 * 不是前一个+1，会左脚踩右脚
 * 也不是max(上一个+1，前一个)
 *      a   b   c   b   a
 * a    1   1   1   1   1
 * b    1   2   2   2   2
 * c    1   2   3   3   3
 * b    1   2   3   4   4
 * c    1   2   4？
 * b
 * a
 * 错误三：左脚踩右脚上天
 *      b   s   b   i   n   i   n   m
 * j    0   0   0   0   0   0   0   0
 * m    0   0   0   0   0   0   0   1
 * j    0   0   0   0   0   0   0   1
 * k    0   0   0   0   0   0   0   1
 * b    1   1   1？
 *
 * 应该是什么呢？左上角啊啊
 * */
public class Solution4_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[][] dp = new int[arr2.length][arr1.length];
        //第一行第一列
        dp[0][0]=arr2[0]==arr1[0]?1:0;
        //第一行
        for (int j = 1; j<arr1.length; j++) {
            if (arr1[j]==arr2[0])dp[0][j]=1;
            else dp[0][j]=dp[0][j-1];
        }
        //第一列
        for (int i = 1; i < arr2.length; i++) {
            if (arr1[0]==arr2[i])dp[i][0]=1;
            else dp[i][0]=dp[i-1][0];
        }
        for (int i =1; i < arr2.length; i++) {
            for (int j = 1; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) dp[i][j] = dp[i-1][j - 1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
            }
        }
        return dp[arr2.length - 1][arr1.length-1];
    }
    //对于代码优化：不用写第一行，多加一行，一列即可，创造全部为0的一行一列
    //9ms击败98.22%
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[][] dp = new int[arr2.length+1][arr1.length+1];
        for (int i =1; i <= arr2.length; i++) {
            for (int j = 1; j <= arr1.length; j++) {
                if (arr1[j-1] == arr2[i-1]) dp[i][j] = dp[i-1][j - 1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[arr2.length][arr1.length];
    }
}
