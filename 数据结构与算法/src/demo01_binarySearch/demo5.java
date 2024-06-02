package demo01_binarySearch;
//Java中二分查找的实现
/*
    在Arrays.util中有Java的二分查找方法
    ctrl+N（搜索类） ctrl+F12（查看方法）看看：它用的是二分查找的第一版
    不同的是，最后它return的是：-（左标+1）

    如果找到了目标数，直接插入到这个数这个下标就行，但是这里面对多个相同查找目标的时候到后面的会有改进
    第一版的二分查找我们提到过：找不到的情况绝对会是左右中标重合在一起：这里我们讨论左右标重合之后的那一步：
    假如数组123，鱼在2.5处：左右标到3，下一步：右标左移，左标还是3
    假如数组123，鱼在1.5处：左右标到1，下一步：左标右移到2。
    如果要把2.5插入123，就应该把3的位置给2.5
    如果要把1.5插入123，就应该把2的位置给1.5
    这下懂了，如果没找到，那么左标的位置，就是查找不到的数应该插入的地方
    为什么返回-（左标+1）呢？负号能理解，但是为什么要+1呢？
    是为了避免该数在数组最左边的情况：123，鱼在0处，左标会到0，返回左标的话就是0：代表找到该插入的地方了，返回0
    返回的0有两种意思：一种是找到数字：另一种是应该插入数字到0，有歧义，所以这里会返回-（左标+1），或许这就和反码为什么要变补码的情况类似吧。
 */

import java.util.Arrays;

public class demo5 {
    public static void main(String[] args) {
        int target = 45;
        int[] arr = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int index=Arrays.binarySearch(arr,target);
        System.out.println(index);
        //插入数的操作
        if (index<0){
            int[] arr1 = new int[arr.length+1];
            int insertIndex=-index-1;
            //arrayCopy内数据的含义：被复制的数组，被复制的数组开始的下标，复制到的数组，复制到的数组的开始下标，复制的个数。
            System.arraycopy(arr,0,arr1,0,insertIndex);
            arr1[insertIndex]=target;
            System.arraycopy(arr,insertIndex,arr1,insertIndex+1,arr.length-insertIndex);
            for (int i = insertIndex+1 ;i<arr1.length ; i++){
                arr1[i]=arr[i-1];
            }
            //使用数组工具类变成String类型
            System.out.println(Arrays.toString(arr1));
        }
    }
}
