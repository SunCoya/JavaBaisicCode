package demo23_DP;

public class Demo01_Fibonacci {
    /*
    * 斐波那契数列为例，非递归
    * 已知子问题的解，推导出当前问题的解，可以表达为一个数学公式
    * 用一维或者二维数组保存结果dp：dynamic programing
    * */
    public static void main(String[] args) {
        System.out.println(fibonacci2(5));
    }
    public static int fibonacci(int n){
        int[] dp = new int[n+1];
        if (n==0)return 0;
        if (n==1)return 1;
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    //动态规划降维
    public static int fibonacci2(int n){
        if (n==0)return 0;
        if (n==1)return 1;
       int dp1 = 0;
       int dp2 = 1;
        for (int i = 2; i < n+1; i++) {
            int dp3= dp1+dp2;
            dp1=dp2;
            dp2=dp3;
        }
        return dp2;
    }
}
