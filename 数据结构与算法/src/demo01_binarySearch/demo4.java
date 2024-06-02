package demo01_binarySearch;
//平衡版
public class demo4 {
    public static int binarySearch3(int[] arr,int target){
        int i =0,j =arr.length;
        //改动一
        while (i<j-1){
            int m =(i+j)>>>1;
            if(target<arr[m]){
                j=m;
            }else{
                //改动二
                i=m;
            }
        }
        //改动三：注意是return i！
        if (arr[i]==target) return i;
        else return -1;
    }
}
