package demo01_binarySearch;
/*
需求：在二分查找中查找到元素有多个，返回要查找的元素的最左边的（下标最小）下标
先想想：为什么会出现这样的情况：心急，抓到鱼就回去了，没有抓到最左边的鱼；是你要抓的鱼，先别返回，记录一下，看看左边有没有鱼
如123445678：第一次就抓到4，第二次到2第三次到3，到最后一次才抓到最左边的4：
所以想要抓到最左边的鱼：你还是得把算法执行到最后（也就是和前面所说的平衡版的二分查找模式一样，但是注意，平衡版的二分查找不一定能够找到最左边或者是最右边的目标数字！）
二分查找LeftMost：找最左侧的目标数字（有多个相同的目标数字的情况）
这个算法其实就是第一版的算法在找到了对应数字之后，继续向左边查找数字：找到什么程度后停止？左标>右标。
*/
public class demo6 {
    public static void main(String[] args) {
        int target = 40;
        int[] arr = {0, 10, 20, 40, 40, 40, 40, 70, 80, 90};
        System.out.println(binarySearchRightMost(arr, target));
    }
    private static int binarySearchLeftMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        //改动1
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mid = arr[m];
            if (target < mid) {
                j = m - 1;
            } else if (mid < target) {
                i = m + 1;
            } else {
                //改动2
                candidate = m;
                j = m - 1;
            }
        }
        //改动3
        return candidate;
    }
    private static int binarySearchRightMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mid = arr[m];
            if (target < mid) {
                j = m - 1;
            } else if (mid < target) {
                i = m + 1;
            } else {
                candidate = m;
                //与leftmost不同的地方
                i = m + 1;
            }
        }
        return candidate;
    }
}
/*
在leftMost中：相较于第一版的二分查找
改动一：设置候选下标candidate，初始值设置为-1，-1代表没有找到的情况
改动二：如果说找到了对应的数组下标不返回，而是记录，并且向左移动J
注意一定是移动J——>m-1,如果是j=m,会死循环，这就可以导致这个candidate一定是越来越小的
改动三：
下面就可以直接返回candidate！没有找到对应下标就返回-1，找到了最左边的对应数字下标就返回下标
在rightMost中：
相较于leftMost，这个移动的是第二处改动中的左标i：可以导致candidate越来越大
*/
