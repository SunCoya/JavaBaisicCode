package demo21_greedy;

import java.util.Arrays;
import java.util.LinkedList;

//找零钱，没解决
public class Solution1_518 {
    /*
     * 想的脑袋僵了，不会，看攻略
     * 这个和跳台阶不一样，那一个有顺序，这个没有！
     * 11111 2111 221 5
     * */
    public static int change(int amount, int[] coins) {
        //栈用来记录流程
        return rec(0,coins,amount,new LinkedList<Integer>(),true);
    }
    //超时做法
    private static int rec(int i, int[] coins, int reminder, LinkedList<Integer> stack, boolean isFirst) {
        //不是第一个才入栈
        if (!isFirst)stack.push(coins[i]);
        //剩余金额小于0无解，等于0有解，大于0继续
        if (reminder==0){
            System.out.print(stack);System.out.println("有解");
            if (!stack.isEmpty())stack.pop();
            return 1;
        }
        else if (reminder<0){
            System.out.print(stack);System.out.println("无解");
            if (!stack.isEmpty())stack.pop();
            return 0;
        }
        //还有剩下的
        int count=0;
        for (int j = i; j < coins.length; j++) count+=rec(j,coins,reminder-coins[j], stack, false);
        if (!stack.isEmpty())stack.pop();
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int amount = 5;
        change(amount,arr);
        //从大到小能减去很多的次数，这里进行了枝剪，当从2开始计算硬币的时候不再去计算5了，从2开始算
        /*
        * （5，0）完毕
        * （2，3）
        *   （2，0）完毕
        *   （1，1）
        *       （1，0）完毕
        * （1，4）
        *   （1，3）
        *   （1，2）
        *   （1，1）
        *   （1，0）完毕
        * */
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        change(amount,arr);

        arr = new int[]{419,408,186,83,};
        change(6249,arr);
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length >>> 1; i++) swap(arr,i,arr.length-1-i);
    }
    private static void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
