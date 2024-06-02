package Day22_List;
import java.util.ArrayList;
import java.util.ListIterator;

/*
列表迭代器ListIterator:List第5种遍历方式。
1.ListIterator与Iterator是什么关系？他有什么更多的用途？
2.ListIterator使用什么方法添加元素？添加元素的位置是怎么决定的？
*/

public class Demo225 {
    public static void main(String[] args) {
        System.out.println("1.ListIterator继承于Iterator，是它的子接口，可以在遍历过程中加元素");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        ListIterator<String> li = arrayList.listIterator();
        System.out.println("2.add()增加元素,增加的位置在当前迭代器指向的位置,默认从0开始, 和remove不一样");
        while (li.hasNext()){
            li.add("嗨嗨嗨");
            String str = li.next();
            //尽量把不为空的写前面
            if ("aaa".equals(str)){
                li.remove();
                li.add("eee");
            }
        }
        System.out.println(arrayList);
    }
}
