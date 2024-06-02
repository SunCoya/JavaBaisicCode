package Day22_List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/*
增强for循环遍历与lambda表达式遍历
1.增强for遍历集合底层使用的是什么？
2.什么对象能够使用增强for遍历？
3.增强for循环格式？
4.如何使用lambda表达式 + Comsumer 接口遍历集合
*/
public class Demo223 {
    public static void main(String[] args) {
        System.out.println("1.增强for遍历：底层就是迭代器");
        System.out.println("2.所有的单列集合与数组才能用增强for遍历");
        System.out.println("3.for(元素类型 元素名 ：数组||单列集合名)");
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Collection<String> clt = new ArrayList<>();
        clt.add("爱丽丝");
        clt.add("洛琪希");
        for (String s : clt) {
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("4.使用集合的forEach方法遍历集合");
        clt.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
    }
}
