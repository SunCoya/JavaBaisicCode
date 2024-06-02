package Day22_List;

import java.util.ArrayList;
import java.util.Iterator;

/*
迭代器遍历Collection元素（可以在有元素要删除的时候用）
1.迭代器依赖索引吗？类名是什么？
2.如何获取迭代器的对象？
3.创建迭代器之后应该如何遍历？
4.如何在迭代器遍历的时候删除元素？
*/
public class Demo222 {
    public static void main(String[] args) {
        System.out.println("1.迭代器不依赖索引，在Java中类是Iterator，是集合专用遍历方式");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        System.out.println("2.利用集合对象的方法，创建迭代器对象，默认指向0索引");
        Iterator<String> iterator = arrayList.iterator();
        System.out.println("3.判断当前位置是否有元素");
        System.out.println("有元素则输出元素，然后后移，注意:遍历的时候不要用集合的方法增加或者删除元素");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //再次获取新的迭代器
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("ddd")) {
                System.out.println("4.用迭代器的方法移除迭代器返回的最后一个元素");
                iterator.remove();
            }
        }
        System.out.println(arrayList);
    }
}
