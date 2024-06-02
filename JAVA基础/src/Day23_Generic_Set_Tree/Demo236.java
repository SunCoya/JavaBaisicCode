package Day23_Generic_Set_Tree;
//与运算中的特殊情况：某一位数的后段全是1
public class Demo236 {
    public static void main(String[] args) {
        System.out.println("对于求index = hash*(arr.length()-1)：当arr的长度是2的整数倍的时候");
        System.out.println("arr.length()-1的补码就全是1，这个是时候求a&b就相当于大数除以小数留下来的余数");
        //00000000 00000000 00000000 00001111
        //00000000 00000000 00000000 01010000
        int a = 15;
        int b = 67;
        System.out.println((a&b));
    }
}
