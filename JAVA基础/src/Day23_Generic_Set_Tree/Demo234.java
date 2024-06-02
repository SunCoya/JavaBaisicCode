package Day23_Generic_Set_Tree;
import java.util.ArrayList;

/*
使用泛型定义的变量在方法中的传递
1.方法里面的变量用什么泛型声明的，那么传递进去的变量能用别的泛型声明吗？
2.用这个泛型的对象可以使用其泛型的子类的对象传递数据吗？
3.泛型通配符？有什么作用？
4.具体该如何使用泛型通配符？
*/
public class Demo234 {
    public static void main(String[] args) {
        ArrayList<Father> list1 = new ArrayList<>();
        ArrayList<Son> list2 = new ArrayList<>();
        System.out.println("1.方法里面的变量用什么泛型声明的，那么传递进去的变量也必须使用这个泛型声明");
        //不能传递这种参数：method(list2);
        method(list1);
        method3(list2);
    }
    //在这个地方void前加泛型<Father>声明，会让arrayList的add对象的时候需要把对象变成Father类型（Java对泛型检查保护）
    public static void method(ArrayList<Father> arrayList) {
        System.out.println("2.用这个泛型的对象可以使用其泛型的子类的对象传递数据");
        Son son = new Son();
        arrayList.add(son);
    }
    public static <E> void method2(ArrayList<E> arrayList) {
        Son son = new Son();
        arrayList.add((E) son);
    }
    //在此处无法让集合加入元素,过不了编译
    public static void method3(ArrayList<? extends Father> arrayList) {
        System.out.println("3.使用泛型通配符来限定泛型类型在某一个范围,可以限制某个继承体系的传递的参数");
        System.out.println("4.<？extends E> 表示可以传递E或者E的所有子类");
        System.out.println("<？super E>表示可以传递E或者E的所有父类");
    }
}

class Father {}

class Son extends Father {}
