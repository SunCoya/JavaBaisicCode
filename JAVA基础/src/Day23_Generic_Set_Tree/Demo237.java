package Day23_Generic_Set_Tree;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*
1.LinkedHashSet与HashSet有什么关系？
2.相比于HashSet有声明特点？
3.底层如何实现？
4.Tree与HashSet有什么关系？
5.相比于HashSet有什么特点？
6.底层用什么实现？
*/
public class Demo237 {
    public static void main(String[] args) {
        System.out.println("1.LinkedHashSet是HashSet的子类");
        System.out.println("2.相比于HashSet，其存取是有序的");
        System.out.println("3.底层的节点能够形成双向链表");
        Student student1 = new Student("张三", 23);
        Student student2 = new Student("张三", 23);
        Student student3 = new Student("李四", 24);
        Student student4 = new Student("王五", 25);
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student4);
        linkedHashSet.add(student3);
        linkedHashSet.add(student2);
        linkedHashSet.add(student1);
        System.out.println(linkedHashSet);
        System.out.println("4.Tree与HashSet同级");
        System.out.println("5.相比于HashSet，它是可排序的,默认按照从小到大排序");
        System.out.println("6.TreeSet底层基于红黑树实现，增删改查性能良好（注意这里就没有Hash表了！！）");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(4);
        treeSet.add(1);
        System.out.println(treeSet);
    }
}
