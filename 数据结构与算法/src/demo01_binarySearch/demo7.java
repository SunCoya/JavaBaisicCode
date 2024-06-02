package demo01_binarySearch;
/*
让返回值变得更加有用
以leftmost为例：简化版leftmost版本
不返回candidate（去掉这个变量），而返回i：就是返回新数应该插入的地方：大于等于查找目标的最左边的数
也就是说，查找插入化为一体：缺点就是不会告诉你有没有那个值，需要你自己去调用该下标去对比（这个时候就有可能造成数组越界了）！
*/

public class demo7 {
    public static void main(String[] args) {
        int target = 25;
        int[] arr = {0, 10, 20, 40, 40, 40, 40, 70, 80, 90};
        System.out.println(binarySearchRightMost2(arr, target));
    }
    private static int binarySearchLeftMost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j)>>>1;
            int mid = arr[m];
            if (target <= mid) {
                //等于的情况也是向左移：因为要继续查找最左边的数
                //如果左移的j的下标不是目标值了也没关系，i会移动到正确的数字上，返回i即可
                j = m-1;
            }else{
                i = m+1;
            }
        }
        return i;
    }

    //返回大于等于目标值的最右边的数的下标（最后一步i+1一定会导致arr[i]大于目标值:所以返回值需要减一）
    //如果找不到目标值：插入的地方：应该是返回值+1
    private static int binarySearchRightMost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j)>>>1;
            int mid = arr[m];
            if (target < mid) {
                j = m-1;
            } else{
                i = m+1;
            }
        }
        return i-1;
    }
}
/*
此处的简化版leftmost中，这里的i可以用作查找排名，返回下标+1就是排名！

也可以可以使用此处的简化版leftmost与rightmost求范围！
比如1244477，可以找（注意下面的案例就算在数组中找不到也是对的：除非你越界数组了）
<4    0————leftMost-1
<=4   0————rightMost
>4    rightMost+1————无穷大
>=4   leftMost————无穷大
*/
