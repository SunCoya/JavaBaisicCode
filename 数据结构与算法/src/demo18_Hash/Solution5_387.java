package demo18_Hash;

import java.util.Arrays;

//第一个不重复字母，返回位置
//数据，下标，是否是对的
public class Solution5_387 {
    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        //定义数组，重复就变超大，不重复就记录
        //也可以定义数组记录重复次数，再从头开始找只有一个的字母
        int[] index = new int[26];
        Arrays.fill(index, 100000);
        for (int i = 0; i < str.length; i++) {
            int strIndex = str[i]-'a';
            if (index[strIndex]==100000)index[strIndex]=i;
            else index[strIndex]=100001;
        }
        int ans=100000;
        for (int i : index) ans=Math.min(i,ans);
        if (ans==100000)ans=-1;
        return ans;
    }
}
