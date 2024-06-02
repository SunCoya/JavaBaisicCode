package Day25_VariablePara_Collections_NestedCol_FightLandlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
集合工具类Collections
1.批量添加元素使用什么方法？
2.打乱集合顺序使用什么方法？
3.排序集合是用什么方法？
4.查找元素使用什么方法？
5.拷贝集合到另一个集合使用什么方法？
6.求最大最小值使用什么方法？
7.交换集合中的元素使用什么方法？
8.填充集合使用什么方法？
*/
public class Demo252 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer>  hashSet = new HashSet<>();

        System.out.println("1.使用addAll方法批量添加元素");
        Collections.addAll(hashSet,1,2,3,4,5);
        Collections.addAll(arrayList,1,2,3,4,5);

        System.out.println("2.使用shuffle方法打乱集合中元素的顺序");
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        System.out.println("3.使用sort方法，排序的写法和Array一样，可以传递单个参数，也能够多传递一个比较规则Comparator");
        Collections.sort(arrayList, (o1,o2) ->o1-o2);
        System.out.println(arrayList);

        System.out.println("4.使用binarySearch方法，二分查找查找元素");
        System.out.println(Collections.binarySearch(arrayList, 3));

        System.out.println("5.使用copy方法，拷贝元素,注意拷贝目标长度>=源长度");
        Collections.copy(arrayList,arrayList);

        System.out.println("6.使用max||min方法，求最大(小)值");
        System.out.println(Collections.max(hashSet));

        System.out.println("7.使用swap方法，交换集合中的元素");
        Collections.swap(arrayList,0,1);
        System.out.println(arrayList);

        System.out.println("8.使用fill方法，填充集合");
        Collections.fill(arrayList,8);
        System.out.println(arrayList);
    }
}
