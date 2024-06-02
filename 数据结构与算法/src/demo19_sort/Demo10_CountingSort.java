package demo19_sort;

/*
* 计数排序，使用最大数来创建数组，再给每个元素计数，适合不大的区间
* 力扣的912题击败100%用户就必须要用这个，因为区间不大
* */
public class Demo10_CountingSort {
    public void sort(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        int[] count = new int[max-min+1];
        for (int i : arr) {
            count[i-min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                arr[index++]=i+min;
                count[i]--;
            }
        }
    }
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        int[] count = new int[max-min+1];
        for (int i : nums) {
            count[i-min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                nums[index++]=i+min;
                count[i]--;
            }
        }
        return nums;
    }
}
