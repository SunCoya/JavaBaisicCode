package Day25_VariablePara_Collections_NestedCol_FightLandlord;

/*
可变参数:JDK5提出，底层就是数组
1.方法中设置可变参数的书写格式？
2.一个方法中能设置多个可变参数吗？
3.可变参数需要设置在方法参数中的的哪个位置呢
*/
public class Demo251 {
    public static void main(String[] args) {
        getSum(0, 1, 2, 3, 4, 5, 6, 7);
    }
    private static void getSum(int a, int... arr) {
        System.out.println("1.格式：数据类型...数据名称");
        System.out.println("2.方法底层中只能写一个可变参数（因为能把很多参数都传递进去）");
        System.out.println("3.需要把可便参数写在方法形参定义的最后,比如上面的a和arr是不能交换的");
        int sum = a;
        for (int i : arr)  sum += i;
        System.out.println(sum);
    }
}
