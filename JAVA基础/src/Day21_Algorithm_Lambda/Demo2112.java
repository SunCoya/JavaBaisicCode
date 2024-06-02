package Day21_Algorithm_Lambda;
//案例：爬台阶一次可以爬1，2，3次
public class Demo2112 {
    public static void main(String[] args) {
        System.out.println(ways(20));   
    }
    public static int ways(int num){
        if (num==1)return 1;
        if (num==2)return 2;
        if (num==3)return 4;
        return ways(num-1)+ways(num-2)+ways(num-3);
    }
}
