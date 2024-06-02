package demo05_recursion;

public class Demo9_YangHui_Memorization {
    public static void main(String[] args) {
        print(15);
    }
    static int[][] arr;
    public static void print(int n) {
        arr = new int[n][];
        for (int j = 0; j < n; j++) {
            arr[j] = new int[j + 1];
            int num = (n - 1 - j) * 2;
            while (num-- > 0) System.out.print(" ");
            for (int i = 0; i <= j; i++) System.out.printf("%-4d", element(i, j));
            System.out.println();
        }
    }
    public static int element(int i, int j) {
        //在最开始的时候判断，我自己写是在下面的赋值判断的，判断了两次，很low
        if (arr[i][j]!=0)return arr[i][j];
        if (i == 0 || i == j) {arr[j][i]=1;return 1;}
        arr[j][i] = element(i, j - 1)+element(i - 1, j - 1);
        return arr[j][i];
    }
}
