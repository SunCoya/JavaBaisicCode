package Day25_VariablePara_Collections_NestedCol_FightLandlord.fightWithLandlord;

import java.util.*;

//第一种排序方式：利用序号进行排序
public class PokerGame2 {
    final static ArrayList<Integer> poker = new ArrayList<>();
    //只需要产生对应关系即可，不需要排序Treemap
    final static HashMap<Integer, String> hashMap = new HashMap<>();

    static {
        for (int i = 0; i < 54; i++) poker.add(i);
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] color = {"♣", "♠", "♥", "♦"};
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < color.length; j++)
                hashMap.put(i * color.length + j, number[i] + color[j]);
        }
        hashMap.put(52, "小王");
        hashMap.put(53, "大王");
    }

    public PokerGame2() {
        Collections.shuffle(poker);
        //使用TreeSet加入元素，自动排序
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        for (int i = 0; i < 3; i++) lord.add(poker.get(i));
        for (int i = 3; i < 54; i++) {
            switch (i % 3) {
                case 0 -> player1.add(poker.get(i));
                case 1 -> player2.add(poker.get(i));
                case 2 -> player3.add(poker.get(i));
            }
        }
        showPoker(lord);
        showPoker(player1);
        showPoker(player2);
        showPoker(player3);
    }

    private void showPoker(TreeSet<Integer> tree) {
        for (Integer integer : tree)
            System.out.print(hashMap.get(integer) + "\t");
        System.out.println();
    }
}
