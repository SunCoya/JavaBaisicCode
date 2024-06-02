package demo18_Hash;

import java.util.HashMap;

public class Solution1_3 {
    public static int lengthOfLongestSubstring(String s) {
        int length=0,start=0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //hashmap返回老的值
            Integer put = hashMap.put(s.charAt(i), i);
            //1.下标从第二个开始计算，注意put的时候可能会遇到前面的字符，导致begin前移了
            if (put!=null)start = Math.max(start,put+1);
            length = Math.max(length,i-start+1);
        }
        return length;
    }
}
