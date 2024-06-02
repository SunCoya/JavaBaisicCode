package Day24_Map;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
/*
LinkedHashMap&TreeMap
1.LinkedHashMap有序，如果后加入的元素替换掉了前面的元素，后加入元素是新建立一个元素挂在链表上还是替代原先元素的位置呢？
2.在TreeMap里面传递自定义对象需要做什么准备？
*/
public class Demo244 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("张三", 23);
        linkedHashMap.put("李四", 24);
        linkedHashMap.put("王五", 25);
        linkedHashMap.put("张三", 23);
        System.out.println("1.后加入的元素：如果和前面的元素键相同，依旧是替代值，而不是继续挂在后面");
        System.out.println(linkedHashMap);

        System.out.println("2.使用TreeMap加入自定义元素依旧要传递比较器或者在类里面实现比较接口");
        //按年龄排序，否则按照姓名
        TreeMap<Student, Integer> treeMap = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getAge() - o2.getAge();
                if (result==0)result =o1.getName().compareTo(o2.getName());
                return result;
            }
        });
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("wangwu", 25);
        Student s3 = new Student("lisi", 24);
        treeMap.put(s1, 1);
        treeMap.put(s2, 1);
        treeMap.put(s3, 1);
        System.out.println(treeMap);
    }
}
