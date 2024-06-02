package demo19_sort;

//归并+插入，也就是Arrays.sort
public class Demo08_MergeInsertSort {
    public void sort(int[] arr) {
        int[] arr2 = new int[arr.length];
        split(arr, 0, arr.length - 1,arr2);
        System.out.println();
    }
    private void split(int[] arr, int left, int right, int[] arr2) {
        if (right-left<=32){
            //在达到一定规模之后就插入排序
            InsertSort(arr,left,right);
            return;
        }
        int mid = (left + right) >>> 1;
        split(arr,left,mid, arr2);
        split(arr,mid+1,right, arr2);
        merge(arr,left,mid,mid+1,right,arr2);
        System.arraycopy(arr2,0,arr,left,right-left+1);
    }
    public void InsertSort(int[] arr,int left ,int right) {
        for (int i = left+1; i <= right; i++) {
            int t = arr[i];
            int index = i-1;
            while (index>=left&&t<arr[index]){
                arr[index+1]=arr[index];
                index--;
            }
            if (index!=i-1)arr[index+1]=t;
        }
    }
    private void merge(int[] arr,int i,int iEnd,int j,int jEnd,int[] arr2){
        int index = 0;
        while (i<=iEnd&&j<=jEnd){
            if (arr[i]<arr[j]){
                arr2[index]=arr[i];
                i++;
            }else{
                arr2[index]=arr[j];
                j++;
            }
            index++;
        }
        if (i>iEnd)System.arraycopy(arr,j,arr2,index,jEnd-j+1);
        else System.arraycopy(arr,i,arr2,index,iEnd-i+1);
    }
}
