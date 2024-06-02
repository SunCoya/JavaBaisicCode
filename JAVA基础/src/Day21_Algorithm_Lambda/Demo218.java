package Day21_Algorithm_Lambda;
import java.util.Arrays;
/*
    1.lambda表达式最基本的特点?
    2.函数式编程(Function Programing)的特点是什么？
    3.lambda表达式能简化所有的匿名内部类吗？
    4.函数式接口的特征?用什么标注？
    5.lambda表达式基本格式？
*/
public class Demo218 {
    public static void main(String[] args) {
        System.out.println("1.lambda表达式最基本的特点:简化匿名内部类的书写(JDK8后出现)");
        System.out.println("2.函数式编程(Function Programing)的特点是忽略面向对象的复杂语法。强调做什么，而不是谁去做");
        System.out.println("3.lambda表达式能简化只能简化函数式接口的匿名内部类，不能简化抽象类。");
        System.out.println("4.函数式接口只有一个抽象方法的接口，使用@FunctionalInterface标注");
        System.out.println("5.lambda表达式基本格式：()->{}");
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.sort(arr, (Integer o1, Integer o2) -> { return o1 - o2; });
    }
}
