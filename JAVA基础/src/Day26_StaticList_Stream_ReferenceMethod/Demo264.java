package Day26_StaticList_Stream_ReferenceMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
/*
转换数据流中的数据类型
1.转换数据流中的数据类型使用什么方法？
2.在这个方法里实现的接口是什么？
3.接口方法中形参是什么？
4.返回的数据是什么？
*/
public class Demo264 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangsan-23","lisi-24","wangwu-25","zhaoliu-26");
        System.out.println("1.使用map方法转换数据类型");
        System.out.println("2.传入Function对象，转换数据，" +
                "第一个参数代表原本（流里面的）的类型，" +
                "第二个参数代表需要变成的类型");
        System.out.println("3.形参表示流里面的每一个数据");
        System.out.println("4.返回的数据代表需要转换的数据的类型");
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(System.out::println);
        //lambda简化
        list.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(System.out::println);
    }
}