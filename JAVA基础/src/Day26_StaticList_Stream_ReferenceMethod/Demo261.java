package Day26_StaticList_Stream_ReferenceMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
不可变集合：这个集合一旦创建之后无法被修改，只能查询
1.如何创建不可变的List类型的集合？创建的集合是什么类型的？
2.如何创建Set类型的不可变集合？
3.如何创建不可变的Map类型的集合？传入的参数有限制吗？
4.当Map中的键值对元素大于10个时，应该如何创建不可变集合呢(具体步骤)？
5.简化的不可变Map方法？
*/
public class Demo261 {
    public static void main(String[] args) {
        System.out.println("1.使用List中的of方法创建不可变集合，这里是list,set,map接口");
        List<String> list = List.of("zhang", "li", "wang", "zhao");
        System.out.println(list);

        System.out.println("2.使用Set中的of方法创建不可变集合，set中内容不能重复，否则报错");
        Set<String> set = Set.of("zhang", "li", "wang", "zhao");
        System.out.println(set);

        System.out.println("3.使用Map中的of方法创建不可变集合,键不能重复，且传递有上限，最多只能传10个键值对对象");
        Map<String, Integer> map = Map.of("张三", 23, "李四", 24);
        System.out.println(map);

        System.out.println("4.如果键值对对象大于10个，就需要先创建一个可变的Map存储数据，再使用ofEntries方法来传入不可变参数");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("zhangsan", 23);
        hashMap.put("lisi", 24);
        System.out.println("(1)entrySet对象返回一个Set集合");
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        System.out.println("(2)使用entries的toArray方法转换成字符串，传入的IntFunction对象,指定返回数组的对象，不指定默认返回Object类型");
        Map.Entry[] array = entries.toArray(value->new Map.Entry[value]);
        System.out.println("(3)可变参数底层就是数组，故需要把set集合转变为数组");
        map = Map.ofEntries(array);

        System.out.println("(4)链式编程写法(这里传入长度0.Java底层自动扩容)");
        map = Map.ofEntries(hashMap.entrySet().toArray(new Map.Entry[0]));

        System.out.println("5.使用Map.copyOf方法创建不可变集合，极简写方法(JDK10版本出现)");
        map = Map.copyOf(hashMap);
        System.out.println(map);
    }

}
