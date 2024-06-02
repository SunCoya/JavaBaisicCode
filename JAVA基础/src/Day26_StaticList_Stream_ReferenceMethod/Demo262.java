package Day26_StaticList_Stream_ReferenceMethod;

import java.util.*;
import java.util.stream.Stream;
/*
Stream流:可以lambda表达式简化集合与数组的操作
获取Stream流
1.如何获取数组的stream流？
2.单列集合如何获取steam流？
3.双列集合如何获取键的stream流与entrySet的stream流？
4.不定量的数据如何获取Stream流？
5.再获取数组的stream流时，如果数组中的数据是基本数据类型，获取的stream流是什么？
*/
public class Demo262 {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        String[] str = {"张xx", "王i", "张y", "张zz", "赵m"};
        Collections.addAll(col, str);
        System.out.println("1.使用数组帮助类的stream方法，获取数组的Stream流,这里遍历依然是使用的Consumer");
        Arrays.stream(str)
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(System.out::println);

        System.out.println("2.使用对象的stream方法获取单列集合的stream流");
        col.stream();

        System.out.println("3.先获取双列集合Key对象与Entry对象，再使用stream方法获取Map对象的stream流");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("zhang", 23);
        hm.put("li", 24);
        hm.keySet().stream().forEach(System.out::println);
        hm.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

        System.out.println("4.使用Stream流的of方法获取不定量的数据的Stream流,需要保证数据类型相同,本质上也是传数组。");
        Stream.of(1, 2, 3).forEach(System.out::println);

        System.out.println("5.注意传基本数据类型的数组的时候出问题，会把整个数组当成一个元素");
        int[] arr = {1, 2, 3};
        Stream.of(arr).forEach(System.out::println);
    }
}
