package demo23_DP;

//钢条切割问题，就是完全背包
/*
 * 长度    0   1   2   3   4   5   6   7   8   9   10
 * 价值    0   1   5   8   9   10  17  17  20  24  30
 * 一根如何切割使得价值最大，横轴总重量，竖轴是可切割的长度
 * 每一行都是在多加了当前重量的价值下，最大的价值
 *       0   1   2   3   4
 * 1     0   1   2   3   4
 * 2     0   1   5   6   10
 * 3     0   1   5   8   10
 * */
public class Demo05_CutRodProblem {
    static int cut(int[] values, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j < dp.length; j++) {
                dp[j] = Math.max(dp[j - i] + values[i], dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cut(new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 4));
    }
}
