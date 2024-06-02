package demo01_binarySearch;
//把‘/’替换成“>>>”
//之前的算法中：int m = (i + j) / 2;有问题！
//当数据量超过定义ijm的数据类型表示的最大值的1/2的情况下,如有可能循环到的（i+j）大于int类型所表示的最大值，基本数据类型越界会变成负数
public class demo2 {
    public static void main(String[] args) {
        int i =0,j=Integer.MAX_VALUE;
        int m = (i+j)/2;
        System.out.println("右标的值：");
        System.out.println(j);
        System.out.println("中标的值：");
        System.out.println(m);
        //如果说要找的值在m的右边：就会出现越界的情况：补码相加（m+j）：
        //01111111 11111111 11111111 11111111+
        //00111111 11111111 11111111 11111111=
        //10111111 11111111 11111111 11111110
        System.out.println("超过int类型范围的数据出错：");
        System.out.println((m+j)/2);
        //正整数“无符号”右移一位的效果和(m+j)/2一样，但是这里m+j是改变了数的正负
        //无符号右移可以解决这个问题，注意一定是无符号右移，也可以适用于更多的语言：如js！
        //无符号右移后的补码数据：
        //01011111 11111111 11111111 11111111
        System.out.println("使用无符号右移解决问题：");
        System.out.println((m+j)>>>1);
    }
}
//不过，int类型的数据能表示21个亿，如果是long类型的数据可以表示42亿个int，这么多的数据我也没见过
//我不知道这里是否真的很有必要使用无符号右移。不过这里给一个解释，后面都是用的无符号右移。
