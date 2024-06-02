package demo19_sort;

import java.util.concurrent.ThreadLocalRandom;

//快拍：数据越多，优势越明显
//每轮找一个基准点元素，比它大的放右边，小的放左边，单轴就找最右边的元素作为基准点
//力扣为了快排专门做了针对，随机化就很重要咯，性能在力扣上还是没有归并排序高
public class Demo09_QuickSort {
    public void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    //如果是只剩两个，改返回什么呢
    private void quick(int[] arr, int left, int right) {
        //在这里也可以判断数量直接用插入排序
        if (left >= right) return;
        int p = partition3(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    //返回基准点（已经固定的索引）
    //i,j用于分区，从头开始，让i变成一个防洪坝，比大于等于right的都放右边
    private int partition(int[] arr, int left, int right) {
        int i = left, j = left;
        while (j!=right){
            //主要是动j！找到比right小的就交换，此时交换后i向后移动一位
            if (arr[j]<arr[right]){
                if (i!=j)swap(arr,i,j);
                i++;
            }
            j++;
        }
        swap(arr,i,j);
        return i;
    }

    //双边快排，最左作为基准点，i在左边，j在最右边，i找小的，j找大的，找到停下，两个交换
    private int partition2(int[] arr, int left, int right) {
        //随机选取
        int element = ThreadLocalRandom.current().nextInt(right-left+1)+left;
        swap(arr,left,element);

        //这里i在此处是为了适应下面的写法
        //如果j==i且i处的值大于left处，就不合适了
        int i = left, j = right;
        while (i<j){
            //这里就写的比较神奇
            //停下的原因一：j碰到i了，所以i右边的东西肯定都比他大
            //停下的原因二：i碰到j了，相遇的这个地方肯定是小的，i右边的肯定都比他大
            while (i<j&&arr[j]>arr[left])j--;
            //这里必须要改成等于，不然i动不了。。。。真是一环扣一环呐
            while (i<j&&arr[i]<=arr[left])i++;
            swap(arr,i,j);
        }
        swap(arr,i,left);
        return i;
    }

    //双边快排中，如果出现重复元素，也会出现极端分区情况，所以等于的情况也交换
    private int partition3(int[] arr, int left, int right) {
        int element = ThreadLocalRandom.current().nextInt(right-left+1)+left;
        swap(arr,left,element);
        int i = left+1, j = right;
        while (i<=j){
            while (i<=j&&arr[i]<arr[left])i++;
            while (i<=j&&arr[j]>arr[left])j--;
            if (i<=j){
                swap(arr,i,j);
                i++;j--;
            }
        }
        //循环外和j交换了，因为j一定停在小的或者相等的
        //j碰i，j会--，要么到最左，要么比它小
        //i碰j，i++结束，j依旧小于
        //ij互换：++--后相反相邻，不用管了。
        //相同位置就要判断一下，看一下这个位置是否是比left大的，这里的操作方式就是在上面的循环中加等于的条件
        swap(arr,j,left);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
