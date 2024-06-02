package demo01_binarySearch;
import java.util.Arrays;
//35. 搜索插入位置
public class Solution1_35 {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(searchInsert2(nums,6));
    }
    public static int searchInsert(int[] nums, int target) {
        int i=0, j=nums.length-1;
        while(i<=j){
            int m=(i+j)>>>1;
            int number=nums[m];
            if(target<number) {
                j=m-1;
            }else if(number<target){
                i=m+1;
            }else{
                return m;
            }
        }
        return i;
    }
    public static int searchInsert1(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i>=0?i:-i-1;
    }
    public static int searchInsert2(int[] nums, int target) {
        //能够解决有重复元素的情况：找最左边的目标值
        int i = 0,j=nums.length-1;
        while (i<=j){
            int m = (i+j)>>>1;
            if (target<=nums[m]){
                j=m-1;
            }else {
                i=m+1;
            }
        }
        return i;
    }
}

