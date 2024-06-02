package Day22_List;

import java.util.ArrayList;

//List常见方法：增删改查
//List集合中，在remove Integer 类型的元素时，优先根据下标删除还是对象的值删除呢？
public class Demo224 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        System.out.println("1.根据下标增");
        arrayList.add(1, "bbb");
        System.out.println(arrayList);
        System.out.println("2.根据下标删");
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println("3.根据下标修改，返回被修改的元素");
        System.out.println(arrayList.set(0, "ccc"));
        System.out.println("4.根据下标查");
        System.out.println(arrayList.get(0));

        System.out.println("5.List中默认优先根据下标删除元素");
        System.out.println("当存储的是Integer数据类型时的特殊情况：想要删除特定数字，需要创建Integer对象");
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.remove(Integer.valueOf(1));
        System.out.println(arrayList2);
    }
}
