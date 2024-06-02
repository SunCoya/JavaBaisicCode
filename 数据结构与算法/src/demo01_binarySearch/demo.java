package demo01_binarySearch;
//第一版二分法
public class demo {
    public static void main(String[] args) {
        int target = 10;
        int[] arr = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println(binarySearchBasic(arr, target));
    }
    private static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        //注意条件别写反了
        while (i <= j) {
            int m = (i + j)>>>1;
            int mid = arr[m];
            //目标在左边
            if (target < mid) {
                j = m-1;
                //目标在右边
            } else if (mid < target) {
                i = m+1;
                //找到目标
            } else {
                return m;
            }
        }
        return -1;
    }
}
