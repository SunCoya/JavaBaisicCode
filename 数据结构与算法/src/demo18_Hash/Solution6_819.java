package demo18_Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Solution6_819 {
    //最常见的单词，第二个是禁用词数组，第一个是句子，有标点符号
    //这个方法已经领先于99%了
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        char[] charArray = paragraph.toCharArray();
        //找单词
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            //大写字母
            if (c >= 'A' && c <= 'Z') charArray[i] = (char) (c += 32);
            //不是字母
            if (!(c >= 'a' && c <= 'z')) continue;
            int j;
            //找到第一个小写字母
            for (j = i + 1; j < charArray.length; j++) {
                char c2 = charArray[j];
                //大写转小写
                if (c2 >= 'A' && c2 <= 'Z') charArray[j] = (char) (c2 += 32);
                //不是字母
                if (!(c2 >= 'a' && c2 <= 'z')) {
                    break;
                }
            }
            String word = new String(charArray, i, j - i);
            hashMap.compute(word,(k,v)->v==null?1:v+1);
            //不是字母改i，记得i会自增，这里就没变要j+1了
            i = j;
        }
        int max = 0;
        String result = null;
        Set<String> set = Set.of(banned);
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            String key = stringIntegerEntry.getKey();
            if (value > max && !set.contains(key)) {
                result = stringIntegerEntry.getKey();
                max = value;
            }
        }
        return result;
    }



    //省流方法
    public String mostCommonWord2(String paragraph, String[] banned) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        //用正则分开，记得split是以什么分开，一定要非^，正则表达式别写错了
        String[] split = paragraph.toLowerCase().split("[^a-z]+");
        //用Set减查找次数
        Set<String> set = Set.of(banned);
        for (String string : split) {
            //先得到get的结果，为空就附一个0，统一加一操作
            //compute帮助简便处理
            //这里对每个词过滤也可以，毕竟是O（1）复杂度，而且Set不会变
            if (!set.contains(string))hashMap.compute(string,(k,v)->v==null?1:v+1);
        }
        //string流（速度慢），max方法找最大的，传入比较器，这里有现成的。
        Optional<Map.Entry<String, Integer>> max = hashMap.entrySet().stream().max(Map.Entry.comparingByValue());
        //有则返回，没有就是null
        return max.map(Map.Entry::getKey).orElse(null);
    }
}