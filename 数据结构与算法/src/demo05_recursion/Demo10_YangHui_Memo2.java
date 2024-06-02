package demo05_recursion;

public class Demo10_YangHui_Memo2 {
    //杨辉三角空间优化成一维数组，，，，一开始这么做不就好了
    public static void main(String[] args) {
        print(15);
    }
    public static void print(int n) {
        int[] arr = new int[n];
        arr[0]=1;
        for (int j = 0; j < n; j++) {
            int num = (n - 1 - j) * 2;
            while (num-- > 0) System.out.print(" ");
            //对数组赋值，要反着来赋值，不会覆盖掉前面的
            for (int i = j;i>0;i--)arr[i] =arr[i]+arr[i-1];
            for (int i = 0; i <= j; i++) System.out.printf("%-4d",arr[i]);
            System.out.println();
        }
    }
}
