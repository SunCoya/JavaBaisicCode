package solved;

import java.util.Arrays;
import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target=9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i]))
                return new int[]{hashMap.get(target-nums[i]),i};
            hashMap.put(nums[i],i);
        }
        return new int[2];
    }
}
