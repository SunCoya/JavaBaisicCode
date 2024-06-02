package Day24_Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//案例：景点计数
public class Demo243 {
    public static void main(String[] args) {
        String[] arr = {"A","B","C","D"};
        String[] list = new String[80];
        Random random = new Random();
        for (int i = 0; i < list.length; i++)
            list[i]=arr[random.nextInt(4)];

        System.out.println("1.使用hashMap存储键（地点）值（统计次数）");
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String value : list) {
            if (hashMap.containsKey(value)) hashMap.put(value, hashMap.get(value) + 1);
            else hashMap.put(value, 0);
        }

        System.out.println("2.记录max的值，防止同时出现两种或者以上景点都是票数最高的");
        int max = 0;

        System.out.println("3.统计最大次数");
        System.out.println("lambda相当于内部类的简写，调用外部类变量，必须是final类型的，故此处无法使用lambda遍历。");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int count = entry.getValue();
            if (max<count)max=count;
        }
        hashMap.forEach((s,i)-> System.out.println(s+" "+i));

        System.out.println("4.根据Max遍历Map");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int count = entry.getValue();
            if (max==count) System.out.print(entry.getKey()+" ");
        }
    }
}
