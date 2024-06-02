package demo19_sort;
//arr1按arr2排序
public class Solution1_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int i = 0; i < arr1.length; i++) arr[arr1[i]]++;
        int index = 0;
        for (int i : arr2) {
            while (arr[i]!=0){
                arr1[index++]=i;
                arr[i]--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]!=0){
                arr1[index++]=i;
                arr[i]--;
            }
        }
        return arr1;
        //aaa
    }
}
