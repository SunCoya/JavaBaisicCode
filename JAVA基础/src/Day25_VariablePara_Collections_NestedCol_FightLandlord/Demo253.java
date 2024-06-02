package Day25_VariablePara_Collections_NestedCol_FightLandlord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
随机生成学生名字，不重复，全部随机完再次随机
1.arrayList的remove方法返回值是什么？
2.如何交换两个arraylist内（其中一个arrayList为空）的元素？
*/

public class Demo253 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Collections.addAll(arrayList,"zhangsan","lisi","wangwu","zhaoliu","qianqi","fengba","sunjiu");
        do{
            Collections.shuffle(arrayList);
            int index = arrayList.size()-1;
            //1.代码简化：remove返回被删除索引
            String str = arrayList.remove(index);
            arrayList2.add(str);
            System.out.println(str);
            System.out.println(arrayList+""+arrayList2);
            if (index == 0){
                System.out.println("集合A（无元素）B（有元素）互换，先把A用B填满，再清空B即可");
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
        }while (new Scanner(System.in).nextLine().equals(""));
    }
}
