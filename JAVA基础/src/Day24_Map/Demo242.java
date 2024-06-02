package Day24_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
/*
Map下面的三种遍历方式具体如何实现？
1：根据取出键遍历
2：根据取出键值对遍历
3：使用forEach方法与BiConsumer遍历
*/
public class Demo242 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",23);
        map.put("李四",24);
        map.put("王五",25);
        System.out.println("1.获取Key的集合,再使用get（key）方法遍历");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"="+map.get(key));
        }

        System.out.println("2.获取所有键值对对象：放到一个集合当中，使用entry中的getKey与getValue遍历(Entry是Map的内部接口)");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        System.out.println("3.使用forEach方法遍历,接收2个对象，分别是Key和Value（底层依然是使用获取键值对的方式遍历）");
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {}
        });
        map.forEach((str,i)->System.out.println(str+"="+i));
    }
}
