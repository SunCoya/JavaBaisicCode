package Day26_StaticList_Stream_ReferenceMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/*
Stream流中间方法
1.由这种方法产生的stream流对使用有什么限制？
2.过滤数据使用什么方法？这个方法里面的接口中返回的数据代表什么意思？
3.如何留下stream流的前几个数据与跳过前几个数据？
4.如何去除元素？根据什么方法去除元素呢（如自定义对象）
5.何合并两个流？
*/

public class Demo263 {
    public static void main(String[] args) {
        System.out.println("1.使用stream流中间方法产生的stream流只能使用一次");

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangsan","lisi","wangwu","wangwu");

        System.out.println("2.使用filter方法过滤数据，filter里面为predicate接口，返回数据表示当前数据留下与否");
        list.stream().filter(s->s.length()==8).forEach(System.out::println);
        System.out.println("3.使用limit方法与skip方法限制数据");
        list.stream().limit(1).forEach(System.out::println);
        list.stream().skip(1).forEach(System.out::println);
        System.out.println("4.使用distinct方法元素去重,依赖hashcode和equals方法（底层用的是hashSet）");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("5.使用contact方法合并流，尽可能使两个流的类型一致（可以多态）");
        Stream.concat(list.stream(),Stream.of("1","2","3")).forEach(System.out::println);
    }
}
