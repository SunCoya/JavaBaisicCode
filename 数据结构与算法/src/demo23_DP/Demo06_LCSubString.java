package demo23_DP;
/*
* 最长公共子串
* 这里到第二行就发现左上角有家伙，可加一
* 不太好降维
*       i   t   h   e   i   m   a
* t     0   1   0   0   0   0   0
* h     0   0   2   0   0   0   0
* e     0   0   0   3   0   0   0
* m     0   0   0   0   0   1   0
* a     0   0   0   0   0   0   2
* */
public class Demo06_LCSubString {
    static int lcs(String a,String b){
        int max = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        //这里长宽别定义反了，有讲究的
        int[][] dp = new int[arr2.length][arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i]==arr1[j]){
                    if (i>0&&j>0)dp[i][j] =  dp[i-1][j-1]+1;
                    else dp[i][j] = 1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lcs("itheima", "thema"));
    }
}
