package demo05_recursion;
//栈内存溢出：爆栈
public class Demo06_Sum {
    public static void main(String[] args) {
        System.out.println(f(12000));
    }
    public static long f(long n){
        if (n==1L)return 1;
        return n+f(n-1);
    }
    //解决：尾调用：函数的最后一步为返回一个函数，别的参数没有！
    //一些语言能够优化尾调用，相当于直接把代码放里面，嵌套变平级，当然java不行，不过这种可以写成循环，不必要学


}
