package Day24_Map;

import java.util.TreeMap;
//案例：统计字符个数
public class Demo245 {
    public static void main(String[] args) {
        System.out.println("如果要统计对象数量不确定，可以利用map去统计");
        String str = "abesaebaebaebsaebsabeabsbaebsebasbeasbase哈哈哈哈哈哈哈哈哈哈哈哈哈";
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(treeMap.containsKey(c))treeMap.put(c,treeMap.get(c)+1);
            else treeMap.put(c,1);
        }
        treeMap.forEach((c,i)-> System.out.println(c+" "+i));
    }
}
