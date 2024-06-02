package demo19_sort;

public class Demo03_InsertionSort {
    public void sort(int[] arr) {
        //从第二个开始到最后不断向前插入
        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            int insertIndex = findInsertIndex(arr, i - 1, insert);
            if (insertIndex!=i) System.arraycopy(arr,insertIndex,arr,insertIndex+1,i-insertIndex);
            arr[insertIndex]=insert;
        }
    }

    private int findInsertIndex(int[] arr, int i, int insert) {
        int index;
        for (index = i; index >= 0; index--) if (insert>=arr[i])break;
        return index+1;
    }
}
