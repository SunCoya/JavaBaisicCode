package demo21_greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//凑硬币个数，从大到小开始计算最少的硬币个数即可，但是会出现凑不满的情况
/*
 * 还有可能出现先贪但是得到的少：
 * 21  15 10 1
 * 先贪15，就变成了15+6=7个币
 * 而10+10+1就三个币
 * 自己写的办法迟早得爆栈
 * */
public class Solution2_322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        reverse(coins);
        int count = 0;
        for (int coin : coins) {
            while (amount > coin) {
                amount -= coin;
                count++;
            }
            //为了跳出外层的循环
            if (amount==coin){
                amount=0;
                count++;
                break;
            }
        }
        if (amount>0)return -1;
        return count;
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length >>> 1; i++) swap(arr, i, arr.length - 1 - i);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @Test
    public void haha() {
        int[] arr = new int[]{186, 419, 83, 408};
        System.out.println(coinChange(arr, 6249));
    }
}
