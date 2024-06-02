package Day23_Generic_Set_Tree;
import java.util.Arrays;

/*
泛型：可以在编译阶段约束操作的数据类型并且进行检查，只能写引用数据类型。
编译的时候会检查泛型，但是转换成class字节码就不会有泛型。
泛型可以写在类，方法，接口后面

泛型类
1.如何定义泛型类？
2.在什么情况下使用泛型类？
3.泛型中一般传入什么字符？
案例：定义一个简单的List集合，实现add方法与get方法
*/
public class Demo231 {
    public static void main(String[] args) {
        System.out.println("1.在定义类的时候,如果类里面有成员不确定的时候，就能在类后面接上泛型");
        System.out.println("2.如果类里面的方法中要传递的变量数据类型,要返回的变量数据类型不确定就可以定义带有泛型的类");
        System.out.println("3.public class ArrayList<E>{}，一般写Type，Element，Key，Value。");
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("aaa");
        System.out.println(arrayList.get(0));
    }
}

class MyArrayList<E> {
    Object[] obj = new Object[10];
    int size;
    public boolean add(E e) {
        obj[size] = e;
        size++;
        return true;
    }
    public E get(int index) {
        return (E) obj[index];
    }
    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
