package Day25_VariablePara_Collections_NestedCol_FightLandlord;

import java.util.*;

/*
集合嵌套
需求：定义集合，键用Province表示，值有多个,表示市
如何定义集合嵌套？
*/
public class Demo254 {
    public static void main(String[] args) {
        System.out.println("在Map中定义值为List或者Set");
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        Collections.addAll(arrayList1, "长沙市", "益阳市", "娄底市");
        Collections.addAll(arrayList2, "广州市", "深圳市");
        Collections.addAll(arrayList3, "福州市", "厦门市");
        hashMap.put("湖南省", arrayList1);
        hashMap.put("广东省", arrayList2);
        hashMap.put("福建省", arrayList3);
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            StringJoiner sj = new StringJoiner(", ");
            for (int i = 0; i < entry.getValue().size(); i++) sj.add(entry.getValue().get(i));
            System.out.println(sj);
        }
    }
}
