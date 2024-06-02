package demo18_Hash;

import java.util.HashSet;

public class Solution3_217_136 {
    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length*2);
        for (int num : nums) {
            //利用返回值判断，之前还查了一次
            if (!hashSet.add(num)) return true;
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        //原本思路：见一个放一个，重复放出来，但是时间复杂度高啦！
        //改：使用异或，所有数字异或，剩下的那个就是答案，异或符合交换律
        //4114 100 001  ->101   001-> 100
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
