package demo05_recursion;

public class Demo8_YangHui {
    public static void main(String[] args) {
        System.out.println(element(2, 4));
        print(6);
    }

    public static int element(int i, int j) {
        if (i == 0 || i == j) return 1;
        return element(i, j - 1) + element(i - 1, j - 1);
    }


    public static void print(int n) {
        for (int j = 0; j < n; j++) {
            int num = (n-1-j)*2;
            while (num-->0) System.out.print(" ");
            for (int i = 0; i <= j; i++) {
                System.out.printf("%-4d",element(i,j));
            }
            System.out.println();
        }
    }
}
