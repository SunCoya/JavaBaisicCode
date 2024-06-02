package demo19_sort;

import java.util.ArrayList;
import java.util.Arrays;

//求排序数组后的最大间距，普通做法只能淘汰56%
//要求时间与空间复杂度是O（n）
//使用长度为一的桶排序就会超出空间限制
//使用基数排序即可
public class Solution3_164 {
    //Arrays.sort，44ms
    public int maximumGap(int[] nums) {
        if (nums.length<2)return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxGap=Math.max(maxGap,nums[i+1]-nums[i]);
        }
        return maxGap;
    }


    //66ms基数排序
    public int maximumGap2(int[] nums) {
        if (nums.length<2)return 0;
        int max= nums[0];
        for (int num : nums)max=Math.max(num,max);

        ArrayList<Integer>[] buckets =new ArrayList[10];
        for (int i = 0; i < 10; i++) buckets[i]=new ArrayList<>();
        int myNum = 1;
        while (myNum<=max){
            for (int num : nums) buckets[num/myNum%10].add(num);
            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer integer : bucket)nums[index++]=integer;
                bucket.clear();
            }
            myNum*=10;
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length-1; i++) maxGap=Math.max(maxGap,nums[i+1]-nums[i]);
        return maxGap;
    }


    /*
     桶排序改进：68ms
     使用适当的range
     （max-min）/range =  nums.length-1
     找最大最小值做区间优化


     再次改进：把最大间距变为桶内最大间距
     （max-min）/range =  nums.length
     让桶个数比数组元素多一个
     还有一些细节需要考虑，这里不多做思考
     */
    public int maximumGap3(int[] nums) {
        if (nums.length<2)return 0;
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max=Math.max(max, i);
            min=Math.min(min, i);
        }
        int range = (max-min)/(nums.length);
        range=Math.max(1,range);
        //桶比元素个数多一个
        Pair[] pairs = new Pair[(max-min)/range+1];
        for (int i : nums) {
            int index = (i-min)/range;
            if (pairs[index]==null)pairs[index]=new Pair();
            pairs[index].add(i);
        }
        //因为最开始与结束肯定是在最两边，中间一定有空！
        int maxGap = 0;
        int lastMax = pairs[0].max;
        for (int i = 1; i < pairs.length; i++) {
            Pair bucket=pairs[i];
            if (bucket!=null){
                maxGap=Math.max(maxGap,bucket.min-lastMax);
                //更新最大值
                lastMax= bucket.max;
            }
        }
        return maxGap;
    }
    static class Pair{
        int max = 0;
        int min = 1000000001;
        void add(int num){
            max =Math.max(max,num);
            min = Math.min(min,num);
        }
    }
}
