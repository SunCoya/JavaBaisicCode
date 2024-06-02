package Day25_VariablePara_Collections_NestedCol_FightLandlord.fightWithLandlord;

public class App {
    public static void main(String[] args) {
        new PokerGame3();
    }
}
/*
    1.创建App与PokerGame，在PokerGame完场准备牌，洗牌，发牌，看牌操作

    2.准备牌：初始化变量写在静态代码块里面，调用牌的变量写在成员变量，并用静态修饰

    3.洗牌调用集合帮助类的方法即可，发牌定义四个集合存储三个人的初始拍以及地主的额外三张牌

    4.在发牌的过程中可以采用除以三取余的方法对三个人发牌
    虽然说相比于按照下标分块发牌，但是这种除余分不同情况思想需要学会

    5.新增看牌方法LookPoker，给每位玩家看牌

    6.给牌排序，在这里新建第二个PokerGame，重写程序结构：
    使用hashMap存储牌的序号与牌，使用arraylist存储牌的序号，使用treeSet给牌排序

    7.新建第三个PokerGame，给牌排序
    使用hashmap存储牌的牌面与其价值，使用arraylist存储牌面，使用arraylist的sort方法排序

    8.灵活使用布尔类型的变量取反！
*/