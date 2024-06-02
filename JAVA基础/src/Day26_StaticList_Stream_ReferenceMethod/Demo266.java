package Day26_StaticList_Stream_ReferenceMethod;

import java.util.*;
import java.util.stream.Collectors;

/*
Stream流转换成List，Set，Map
1.使用什么去接收stream转成的List？
2.如何转换成List？方法中需要传递什么参数？
3.如何转换成Set？转换成Set数据有什么变化吗？
4.如何转换成Map？传入的接口的数量？
5.返回的参数是？
* */
public class Demo266 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan-男-23", "zhangsan-男-23", "lisi-女-24", "lisi-女-24");
        System.out.println("1.使用List接口接收stream流转换的List对象，Set，Map皆如此");

        System.out.println("2.在collect终结方法里面传递Collectors工具类,使用toList方法转换为List");
        List<String> newList = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());

        System.out.println("3.collect方法里面传递toSet方法转换成Set，传递toSet方法能够去重");
        Set<String> newSet = list.stream().filter(s -> "女".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(newList + "" + newSet);

        list = new ArrayList<>();
        Collections.addAll(list, "zhangsan-男-23", "lisi-女-24");
        System.out.println("4.转换成Map依然使用collect方法,要先传入Collectors工具类的toMap方法，" +
                "再传递两个Function对象确定返回参数，键不能够重复傲，不会像Set那样给你自动删除");
        System.out.println("5.返回的参数分别代表键和值的对象");
        Map<String, Integer> newMap = list.stream().collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[2])
        ));
        System.out.println(newMap);
    }
}
