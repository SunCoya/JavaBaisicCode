package demo23_DP;

/*
* 01背包：动态规划
* 背包最高接受重量：10
* 编号  重量    价格  简称
* 0     4       160     A
* 1     8       240     R
* 2     5       30      S
* 3     1       1000    D
*
* 其动态规划思想：
* 纵轴物品，横轴重量
*       0       1       2       3       4       5       6       7       8       9       10
*       0       0       0       0       0       0       0       0       0       0       0
* 0     0       0       0       0       A       A       A       A       A       A       A
* 1     0       0       0       0       A       A       A       A       R       R       R  好，这里的R进入如何判断呢？
* 2     0       0       0       0       A       A       A       A       R       R       R  这里到9判断A+S与R
* 3     0       D       D       D       D       DA      DA      DA      DA      DR      DR
* if(装不了该物品){
*   //从上一行来
*   dp[i][j]=dp[i-1][j];
* }else{
*   dp[1][8]=max(dp[0][8],R)
*   dp[3][5]=max(dp[2][5],dp[2][5-D.weight])//也就是上一行中的最优解
*   dp[i][j]=max(dp[i-1][j],item.val+dp[i-1][5-item.weight])//当前价值加上一行最优解
* }
* 在上一行一整行中找，去找最优解
* 思考：对于当前节点，就是当前重量的最优解
* 要么继承上面的，要么就拿上面那一行加我自己
* }
* */
public class Demo03_KnapsackProblem {
    static class Item{
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1,"黄金",4,160),
                new Item(2,"宝石",8,240),
                new Item(3,"白银",5,30),
                new Item(4,"钻石",1,1000)
        };
        select(items,10);
        select2(items,10);
        select3(items,10);
    }

    private static void select(Item[] items, int total) {
        int[][] dp = new int[items.length+1][total+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {//这里由于i从1开头，减一对应item，要么不要第一行，自己写第一行
                if (j<items[i-1].weight)dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],items[i-1].value+dp[i-1][j-items[i-1].weight]);
            }
        }
        print(dp);
    }
    //不用第一行
    private static void select2(Item[] items, int total) {
        int[][] dp = new int[items.length][total+1];
        for (int j = 0; j < dp[0].length; j++) if (items[0].weight<=j)dp[0][j]=items[0].value;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j<items[i].weight)dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],items[i].value+dp[i-1][j-items[i].weight]);
            }
        }
        print(dp);
    }
    //降维：其实就降了空间复杂度
    private static void select3(Item[] items, int total) {
        int[] dp = new int[total+1];
        for (int j = 0; j < dp.length; j++) if (items[0].weight<=j)dp[j]=items[0].value;
        for (int value : dp) System.out.printf("%8d", value);
        System.out.println();
        for (int i = 1; i < items.length; i++) {
            for (int j = total; j > 0; j--) {//倒着来，防止后面被前面的覆盖了
                Item item = items[i];
                if (j>=item.weight) dp[j]=Math.max(dp[j],item.value+dp[j-item.weight]);
            }
            for (int k : dp) System.out.printf("%8d", k);
            System.out.println();
        }
    }
    private static void print(int[][] dp){
        for (int[] ints : dp) {
            for (int anInt : ints) System.out.printf("%8d", anInt);
            System.out.println();
        }
    }
}
