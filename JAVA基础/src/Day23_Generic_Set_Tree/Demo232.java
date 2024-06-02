package Day23_Generic_Set_Tree;
import java.util.ArrayList;
import java.util.Iterator;
/*
泛型方法

1.泛型方法声明的位置？
2.如果泛型方法中传入两个参数，这两个参数的类型都可以被泛型限制吗？

案例：定义工具类，实现方法使得：
1.两个List集合添加到一起
*/
public class Demo232 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(ListUtils.addAll1(list1,list2));;
    }
}

class ListUtils{
    private ListUtils(){}
    //定义静态方法addAll，用来添加两个集合的元素
    public static <E> ArrayList<E> addAll1(ArrayList<E> list1, ArrayList<E> list2){
        System.out.println("1.泛型声明<>位置在返回类型前");
        System.out.println("2.如果泛型方法中传入两个参数，这两个参数的类型都可以被泛型限制");
        Iterator<E> iterator = list2.iterator();
        while (iterator.hasNext()){
            list1.add(iterator.next());
        }
        return list1;
    }
}
