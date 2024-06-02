package demo05_recursion;
//递归二分查找
public class BinarySearch {
    public static void main(String[] args) {
        int target = 10;
        int[] arr = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.println(method(arr,target,0,arr.length-1));
    }
    public static int method(int[] arr,int target,int i,int j){
        if (i>j)return -1;
        int m=(i+j)>>>1;
        if(target<arr[m]) return method(arr,target,i,m-1);
        if(arr[m]<target) return method(arr,target,m+1,j);
        return m;
    }
}
