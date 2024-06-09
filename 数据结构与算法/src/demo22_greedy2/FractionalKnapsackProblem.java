package demo22_greedy2;

import java.util.Arrays;
import java.util.Comparator;

//分数背包问题
//有物品，重量，价格，选取均价最高的带走即可
public class FractionalKnapsackProblem {
    static class Item{
        int index;
        int weight;
        int value;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int unitValue(){
            return value/weight;
        }
        @Override
        public String toString() {
            return "Item{"+index +'}';
        }

        public static void main(String[] args) {
            Item[] items = new Item[]{
                    new Item(0,4,24),
                    new Item(1,8,160),
                    new Item(2,2,4000),
                    new Item(3,6,108),
                    new Item(4,1,4000)
            };
            select(items,10);
        }
        public static void select(Item[] items, int total){
            //降序排序
            int max = 0;
            Arrays.sort(items, Comparator.comparingInt(Item::unitValue).reversed());
            for (Item item : items) {
                if (total>item.weight){
                    total-=item.weight;
                    max+=item.value;
                }else {//拿不完
                    max+=item.unitValue()*total;
                    break;
                }
            }
            System.out.println(max);
        }
    }
}
