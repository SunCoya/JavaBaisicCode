package demo01_binarySearch;

import java.util.Arrays;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class Solution2_34 {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,9,9,9,9,9,9,9,12};
        System.out.println(Arrays.toString(searchRange3(nums,9)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] array ={-1,-1};
        //找最左边的值，看看有没有这个数,同时也能够判断是否存在。
        int i = 0,j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target <=nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (nums.length==0||i>=nums.length|| nums[i]!=target){//数组越界:1.空数组2.找的数大于数组最后一个3.没找到
            return array;
        }
        array[0] = i;

        //找最右边的值
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        array[1] = i - 1;
        return array;
    }
    public static int[] searchRange2(int[] nums, int target) {
        //第二版：使用candidate简化判断：只要不是-1，那么在数组中就一定存在！
        int[] array ={-1,-1};
        int i = 0,j = nums.length - 1,candidate = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target <nums[mid]) {
                j = mid - 1;
            } else if (nums[mid]<target){
                i = mid + 1;
            }else {
                candidate=mid;
                j = mid - 1;
            }
        }
        if (candidate==-1){
            return array;
        }
        array[0] = i;

        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        array[1] = i - 1;
        return array;
    }
    public static int[] searchRange3(int[] nums, int target) {
        //第三版：合并leftMost与rightMost
        return new int[]{findMost(nums,target,true),findMost(nums,target,false)};
    }
    public static int findMost(int[] nums, int target,boolean flag){
        int i = 0,j = nums.length-1;
        int candidate = -1;
        while (i<=j){
            int mid = (i+j)>>>1;
            int number = nums[mid];
            if (target<number){
                j = mid- 1;
            }else if (number<target){
                i= mid+1;
            }else{
                candidate=mid;
                if (flag){
                    j = mid -1;
                }else {
                    i = mid +1;
                }
            }
        }
        return candidate;
    }
}

