package Day26_StaticList_Stream_ReferenceMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
方法引用
把已经有的方法当作函数式接口中抽象方法的方法体
也就是说替代了接口类的对象（函数式接口）
方法形参和返回值请与接口中的保持一致（最后一种情况可以不用保持一致）
mybatis-plus中大量用到了方法引用
1.方法引用符号为？

2.使用类名调用静态方法
类名：：方法名

3.使用对象调用成员方法
对象名：：方法名
如何调用父类与本类对象的方法？

4.使用类名调用构造方法
类名：：new

5.使用数组调用构造方法
int[]::new

6.使用类名调用成员方法
相当于用接口中的第一个参数调用这个对象中的函数
*/
public class Demo267 {
    public static void main(String[] args) {
        System.out.println("1.方法引用符号为双冒号：：");

        System.out.println("2.使用类名调用静态方法");
        //arrayList转类型
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "1", "2", "3", "4");
        //在格式转换里面使用ParseInt方法转换类型
        arrayList.stream().map(Integer::parseInt).forEach(System.out::println);
        arrayList.clear();


        System.out.println("3.使用对象调用成员方法");
        System.out.println("调用本类的成员方法使用this::   父类使用super::");
        Collections.addAll(arrayList,"zhangsan","lisi","wangwu");
        arrayList.stream().filter(new StringJudge()::test).forEach(System.out::println);
        arrayList.clear();


        System.out.println("4.引用构造方法：为了创建对象，这里的学生对象额外加了一个构造方法");
        System.out.println("在这里需要加一个Student里面的构造方法，使得其接收一个字符串，并转换成相应属性");
        Collections.addAll(arrayList,"zhangsan,23","lisi,24","wangwu,25");
        List<Student> students = arrayList.stream().
                map(Student::new).
                collect(Collectors.toList());
        System.out.println(students);
        arrayList.clear();

        System.out.println("5.使用数组名调用构造方法");
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,1,2,3,4,5,6);
        integers.toArray(Integer[]::new);

        System.out.println("6.使用类名调用成员方法");
        System.out.println("在抽象方法中的第一个参数（这里是String）代表了能引用哪个类中的方法，其他类的方法用不了（限制类）");
        System.out.println("第二个参数到最后的参数要和调用的成员方法中的形参一致");
        System.out.println("如果抽象方法中那个没有参数，调用的成员方法就是无参方法");
        System.out.println("相当于拿第一个参数去调用其他的函数");
        arrayList.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
class StringJudge {
    public boolean test(String s){
        return s.startsWith("z")&&s.length()==8;
    }
}
