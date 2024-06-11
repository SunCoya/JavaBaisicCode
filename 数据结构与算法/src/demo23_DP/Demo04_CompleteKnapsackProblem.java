package demo23_DP;

/*
    完全背包问题

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
                new Item(1,"黄金",4,160),
                new Item(2,"宝石",8,240),
                new Item(3,"白银",5,30),
                new Item(4,"钻石",1,1000)
        };
    }

}
