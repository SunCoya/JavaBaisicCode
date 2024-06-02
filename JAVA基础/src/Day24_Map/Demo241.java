package Day24_Map;

import java.util.HashMap;
import java.util.Map;
/*
双列集合(键值一一对应)
1.键值对对象在Java中的名字与特点？
Entry对象，键不可以重复，值可以重复

2.HashMap的特点？这些特点由什么决定？HashMap底层是什么结构？
HashMap特点：无序，不重复，无索引，由键决定
HashSet与HashMap底层结构都是一样的，都是哈希表结构

3.Map（双列集合顶层接口）常见方法有哪些（增删查）？
(1)增：非add，是put，HashMap加入元素与HashSet有何不同？
(2)删：remove，clear，remove方法根据什么删除键值对呢？
(3)查：containsKey，containsValue，isEmpty，size

4.当数组长度超过8并且数组长度大于等于64，那么就把链表转换成红黑树
*/
public class Demo241 {
    public static void main(String[] args) {
        //用子类创建对象
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",23);
        map.put("李四",24);

        System.out.println("1.添加相同的键会修改键的值,返回被修改的值，没有修改就返回空。和set返回的true和false不一样");
        System.out.println(map.put("张三",24));
        System.out.println(map.put("王五",25));
        System.out.println(map);

        System.out.println("2.删除：根据键删除");
        map.remove("王五");
        System.out.println(map);

        System.out.println("3.查询：是否有key，value，规模与是否为空");
        System.out.println(map.containsKey("李四"));
        System.out.println(map.containsValue(24));
        System.out.println(map.size()+" "+map.isEmpty());
        map.clear();
    }
}
