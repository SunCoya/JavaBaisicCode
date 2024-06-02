package Day26_StaticList_Stream_ReferenceMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;
/*
Stream流的终结方法
1.如何统计流中的数据数量？
2.如何把流变成数组？传入的接口是什么？接口中返回的数据代表什么？
*/
public class Demo265 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangsan-23","lisi-24","wangwu-25","zhaoliu-26");
        System.out.println("1.使用count方法统计流中的数量");
        long  l = list.stream().count();

        System.out.println("2.使用toArray方法变成数组,传入的参数是IntFunction对象，和上面的Map.Entry一样，返回数据代表指定大小的数组");
        String[] str = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        //简写
        str = list.toArray(s->new String[s]);
        System.out.println(Arrays.toString(str));
    }
}
