package Day23_Generic_Set_Tree;
import java.util.Comparator;
import java.util.TreeSet;

//TreeSet加入自定义对象的两种方法
public class Demo238 {
    public static void main(String[] args) {
        System.out.println("方法一：在自定义类中实现comparable接口");
        Student student1 = new Student("李四",24);
        Student student2 = new Student("王五",26);
        Student student3 = new Student("赵六",25);
        Student student4 = new Student("张三",23);
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        System.out.println(treeSet);

        System.out.println("方法二：创建TreeSet对象的时候，传递Comparator指定规则，这个方法优先级更高");
        TreeSet<String> treeSet1 = new TreeSet<>();
        TreeSet<String> treeSet2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                if (result == 0) result = o1.compareTo(o2);
                return result;
            }
        });
        treeSet1.add("c");
        treeSet1.add("ab");
        treeSet1.add("bcd");
        treeSet1.add("qwqwq");
        treeSet2.add("c");
        treeSet2.add("ab");
        treeSet2.add("bcd");
        treeSet2.add("qwqwq");
        System.out.println(treeSet1);
        System.out.println(treeSet2);
    }
}
