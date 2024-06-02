package demo05_recursion;

public class Demo04_Fibonacci {
    public static void main(String[] args) {
        System.out.println(method(12));
    }
    public static int method(int i){
        //这是一个简单的求斐波那契，但是没有记忆，效率低！
        if (i==0)return 0;
        if (i==1)return 1;
        return method(i-1)+method(i-2);
    }
    //对于兔子问题：第六个月的兔子数量=第五个月兔子数量+第五个月成熟的兔子数量（也就是第四个月兔子数量，四月的兔子过了一个月都成熟了）
    //对于青蛙跳台阶问题，f(20)=f(19)跳一阶+f(18)跳两阶
}
