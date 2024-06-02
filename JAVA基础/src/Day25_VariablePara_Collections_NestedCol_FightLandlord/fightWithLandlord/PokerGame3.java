package Day25_VariablePara_Collections_NestedCol_FightLandlord.fightWithLandlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//第二种排序方式：利用牌的价值进行排序
public class PokerGame3 {
    final static ArrayList<String> arrayList = new ArrayList<>();
    final static HashMap<String, Integer> hashmap = new HashMap<>();

    static {
        String[] color = {"♣", "♥", "♠", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String n : number) {
            for (String c : color) {
                arrayList.add(n + c);
            }
        }
        arrayList.add("小王");
        arrayList.add("大王");
        //放入Map集合 如果map中有就查询价值，没有使用数字
        hashmap.put("J", 11);
        hashmap.put("Q", 12);
        hashmap.put("K", 13);
        hashmap.put("A", 14);
        hashmap.put("2", 15);
        hashmap.put("小", 20);
        hashmap.put("大", 30);
    }

    public PokerGame3() {
        Collections.shuffle(arrayList);
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) lord.add(arrayList.get(i));
        for (int i = 3; i < 54; i++) {
            switch (i % 3) {
                case 0 -> player1.add(arrayList.get(i));
                case 1 -> player2.add(arrayList.get(i));
                case 2 -> player3.add(arrayList.get(i));
            }
        }

        lord.sort(Comparator.comparingInt(this::trans));
        player1.sort(Comparator.comparingInt(this::trans));
        player2.sort(Comparator.comparingInt(this::trans));
        player3.sort(Comparator.comparingInt(this::trans));

        lookPoker("地主牌", lord);
        lookPoker("玩家一", player1);
        lookPoker("玩家二", player2);
        lookPoker("玩家三", player3);
    }

    public void lookPoker(String name, ArrayList<String> arrayList) {
        System.out.print(name + "：");
        for (String s : arrayList) System.out.print("\t" + s);
        System.out.println();
    }

    public Integer trans(String str) {
        String n = str.substring(0, str.length() - 1);
        if (hashmap.containsKey(n)) return hashmap.get(n);
        else return Integer.parseInt(n);
    }
}