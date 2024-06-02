package solved;

import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    //这个题目就遍历字符串即可
    //index记录开始计算没有重复字符段的下标，i代表当前位置
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int index = 0, length = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>(128);
        for (int i = 0; i < n; i++) {
            Integer put = hashMap.put(s.charAt(i), i);
            //加入失败，这里的话，判断的下标始终要大一点
            if (put != null) index = Math.max(put + 1, index);
            //加入成功和成功都要更新length，说明不重复，i+1是因为下标相减之后并不是字符串长度
            length = Math.max(length, i - index + 1);
        }
        return length;
    }
}
