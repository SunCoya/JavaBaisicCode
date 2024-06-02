package demo05_recursion;

import java.util.Arrays;

public class Demo05_Fibonacci_Memorization {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(40));
        long end = System.currentTimeMillis();
        System.out.println("花费时间ms：（已优化）"+(end-start));
        //时间复杂度将为n，空间复杂度提升未n
        start = System.currentTimeMillis();
        System.out.println(Demo04_Fibonacci.method(40));
        end = System.currentTimeMillis();
        System.out.println("花费时间ms：（未进行优化）"+(end-start));
    }


    static int[] cache;
    public static int fibonacci(int n){
        //根据参数new数组
        cache  = new int[n+1];
        //初始化为-1
        Arrays.fill(cache,-1);
        cache[0]=0;
        cache[1]=1;
        return f(n);
    }
    public static int f(int n){
        //如果有数
        if(cache[n]!=-1)return cache[n];
        //在遍历树中，只需要左边遍历一遍，然后全部记录即可
        int f1 = f(n-1);
        cache[n-1] = f1;
        int f2 = f(n-2);
        return f1+f2;
    }
}
