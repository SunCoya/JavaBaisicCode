package Day21_Algorithm_Lambda;

/*
1.lambda表达式省略核心：能够从原来接口中推导出来的就可以省略

2.默认方法是抽象方法吗？
由于默认方法已经有了实现，所以它们不是抽象方法

3.如果一个接口中声明的抽象方法是重写了Object类中任意一个public方法
那么这些抽象方法并不会算入接口的抽象方法数量中
因为任何接口的实现类都会从其父类Object或其它地方获得这些方法的实现。

4.有多个方法的接口就不是函数式接口了吗？
有多个方法的接口，只要只有一个自己声明的抽象方法，就是函数式接口。
*/
public class Demo219 {
    public static void main(String[] args) {
        method(a->a+666);
    }
    public static void method(Swim swim) {
        System.out.println("1.方法可以省略参数类型，只有一个参数则可省略大括号");
        System.out.println("2.只有一条语句的时候可以不写分号与大括号，可以不写return标识符，也能够return");
        System.out.println(swim.swimming("嘎嘎"));;
    }
}

@FunctionalInterface
interface Swim {
    String swimming(String a);
    boolean equals(Object o);
    default void swimming2(){}
}

