package demo18_Hash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//字母异位词分组
public class Solution2_49 {
    //两个地方疑惑1.hashmap不能存一键多值：你把值变成list就可以了
    // 2.hashmap怎么给字符串排序啊，别自己写，三行解决
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            //三行解决，双轴快速排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sort = new String(charArray);
            //不包含，创建新ArrayList

            //这里老师用例computeIfAbsent方法，可以去了解一下
            if (!hashMap.containsKey(sort)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                hashMap.put(sort, arrayList);
            }
            //包含，则假如新arrayList
            else hashMap.get(sort).add(str);
        }
        return  new ArrayList<>(hashMap.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<ArrayKey, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            //方法二：用数组作为map
            ArrayKey key = new ArrayKey(str);
            if (!hashMap.containsKey(key)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                hashMap.put(key, arrayList);
            }else hashMap.get(key).add(str);
        }
        return  new ArrayList<>(hashMap.values());
    }

    //用来封装整数数组（提供equals方法）
    static class ArrayKey{
        int[] key = new int[26];
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(key, arrayKey.key);
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }
        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) key[str.charAt(i)-'a']++;
        }
    }

}
