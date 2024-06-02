package demo01_binarySearch;
//替代版本
public class demo1 {
    public static void main(String[] args) {
        int target = 10;
        int[] arr = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println(binarySearchAlternative(arr, target));
    }
    private static int binarySearchAlternative(int[] arr, int target) {
        //第一处改动
        int i = 0, j = arr.length;
        //第二处改动
        while (i < j) {
            int m = (i + j)>>>1;
            int mid = arr[m];
            if (target < mid) {
                //第三处改动
                j = m;
            } else if (mid < target) {
                i = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }
}

