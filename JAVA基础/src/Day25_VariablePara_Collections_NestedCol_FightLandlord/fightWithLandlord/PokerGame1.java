package Day25_VariablePara_Collections_NestedCol_FightLandlord.fightWithLandlord;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame1 {
    final static ArrayList<String> arrayList = new ArrayList<>();

    //准备：54张牌，这里使用静态代码块：随着类加载，只执行一次，可以不用一个一个写static修饰的代码了
    //但是这个类的方法不能访问静态代码块中的变量
    static {
        //在准备牌的时候，不用一张一张加，可以先把最基础的属性分开（花色与数字）
        String[] color = {"♣", "♥", "♠", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String n : number) {
            for (String c : color) {
                arrayList.add(n + c);
            }
        }
        arrayList.add("小王");
        arrayList.add("大王");
    }

    public PokerGame1() {

        //洗牌:使用集合帮助类的方法即可
        Collections.shuffle(arrayList);

        //发牌：一个底牌，三个玩家
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) lord.add(arrayList.get(i));
        for (int i = 3; i < 54; i++) {
            //这种有确定的情况数量就可以使用switch
            switch (i % 3) {
                case 0 -> player1.add(arrayList.get(i));
                case 1 -> player2.add(arrayList.get(i));
                case 2 -> player3.add(arrayList.get(i));
            }
        }

        //排序：这里是用键代表序号，用值代表牌，这样的画排序就直接按照键来排就可以了
        //真正需要的是序号，就像拼图游戏一样，真正要操作的是坐标，而不是图片,在Game2里面排序

        //看牌
        lookPoker("地主牌", lord);
        lookPoker("玩家一", player1);
        lookPoker("玩家二", player2);
        lookPoker("玩家三", player3);

    }

    public void lookPoker(String name, ArrayList<String> arrayList) {
        System.out.print(name + "：");
        for (String s : arrayList) {
            System.out.print("  \t" + s);
        }
        System.out.println();
    }
}
