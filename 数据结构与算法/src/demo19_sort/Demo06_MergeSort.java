package demo19_sort;

/*
归并排序：分治思想，其实也是排序上的二分法：不断切成两半从最小的开始合并，慢慢合2到最大的两半
这一个方法缺点就是需要额外空间
*/
public class Demo06_MergeSort {
    public void sort(int[] arr) {
        int[] arr2 = new int[arr.length];
        split(arr, 0, arr.length - 1,arr2);
        System.out.println();
    }
    private void split(int[] arr, int left, int right, int[] arr2) {
        if (left==right)return;
        //分的时候如果是技术那就是左边多右边少
        int mid = (left + right) >>> 1;
        split(arr,left,mid, arr2);
        split(arr,mid+1,right, arr2);
        //合并，两个的时候就应该合并了啊
        merge(arr,left,mid,mid+1,right,arr2);
        //赋值回去，这里在下面的方法中做错了，i变化了导致赋值错误
        System.arraycopy(arr2,0,arr,left,right-left+1);
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
