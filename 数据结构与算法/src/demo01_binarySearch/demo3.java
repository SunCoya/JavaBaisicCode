package demo01_binarySearch;
//算法复杂度分析：时间复杂度，空间复杂度。
public class demo3 {
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length==target){
                return i;
            }
        }
        return -1;
    }
    //算法最坏情况：找不到目标，下面是代码执行统计：
    /*
        元素个数n
        int i=0;                    1
        i<arr.length                n+1
        i++                         n
        if(arr.length==target)      n
        return -1                   1
        总共：3n+3
    */
    private static int binarySearchBasic(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j)>>>1;
            if (target < arr[m]) { j = m-1;}
            else if (arr[m] < target) { i = m+1; }
            else {return m;}
        }
        return -1;
    }
    /*
    算法最坏情况：找不到目标：如[2，3，4，5]，找左边的数据1与找右边的数据6，那一个运行得更久呢？找6
    因为m是向下取整的，导致找右边的数据会比找最左边的数据花费时间更多
    数据共有n个：
    如果需要找的数据在最右边，n的变化：n=n/2
    如果数据在最左边，n的变化：n=(n-1)/2
    这里按数据在最右边的情况下对代码执行统计：
        元素个数                循环次数
        1                       1
        2-3                     2
        4-7                     3
        8-15                    4
        16-31                   5
        32-63                   6
        最坏的情况就是向下取整的L=log_2(n)+1 次
        代码                                  运行次数
        int i = 0, j = arr.length - 1;          2
        return -1;                              1
        i <= j                                  L+1
        int m = (i + j)>>>1;                    L
        if (target < arr[m]) { j = m-1;}        L
        else if (arr[m] < target) { i = m+1; }  2L
        else {return m;}
        共5log_2(n)+9次
    */
    /*
    情况对比：3n+3与5log_2(n)+9
        n=5时：线性算法：18t
                二分法：19t
        n=6时：线性算法：21t
                二分法：19t
        往后二分算法都优于线性算法
    */
}