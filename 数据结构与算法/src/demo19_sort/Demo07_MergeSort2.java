package demo19_sort;

//自下而上的归并排序，非递归，其实就是从小到大的希尔排序，性能比希尔又高一点
public class Demo07_MergeSort2 {
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
    public void sort(int[] arr) {
        int length = arr.length;
        int[] arr2 = new int[length];
        for (int width = 1; width < length; width*=2) {
            for (int left=0;left<length;left+=2*width){
                //处理右边界，这里处理的就很优秀了，避免了merge里面每个参数都去调整
                int right = Math.min(length-1,left+2*width-1);
                int leftEnd = Math.min(left+width-1,length-1);
                //这里的mid不能用相加除以二！一个长度8，一个长度2，合并之后其实要让2的开头和8比
                merge(arr,left,leftEnd,leftEnd+1,right,arr2);
                //这里可以改改，因为每一遍循环都会填满下面的数组
                System.arraycopy(arr2,0,arr,left,right-left+1);
            }
        }
    }
}
