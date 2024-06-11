package demo23_DP;

import java.util.Arrays;

/*
    完全背包问题
    每个物品有无限个
    从左到右，和上面的比，当前=加入一个元素+这列之前的最佳数据
* */
public class Demo04_CompleteKnapsackProblem {
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
                new Item(1,"黄金",2,3),
                new Item(2,"宝石",3,4),
                new Item(3,"白银",4,7),
        };
        select(items,6);
    }
    //破案了，正着就是完全，反着就01
    private static void  select(Item[] items, int total){
        int[] dp = new int[total+1];
        for (int j = 0; j < dp.length; j++) if (j>=items[0].weight)dp[j]=(j/items[0].weight)*items[0].value;
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                Item item = items[i];
                if(j>=item.weight)dp[j]=Math.max(dp[j],dp[j-item.weight]+item.value);
            }
            System.out.println(Arrays.toString(dp));
        }
    }
}
