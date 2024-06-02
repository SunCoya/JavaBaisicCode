package Day21_Algorithm_Lambda;
/*
递归案例：爬台阶
对于一节台阶，只有一种方法
对于两节台阶，有两种爬法
对于20阶台阶：
如果爬上了19阶，则剩下一种爬法：
如果爬上了18阶，则剩下两种爬法:第一种是爬上19阶（被包含在F（19）了），第二种方法是爬上20
20阶的爬法=19阶爬法+18阶爬法
*/
public class Demo2111 {
    public static void main(String[] args) {
        System.out.println(ways(20));
    }
    public static int ways(int num){
        if (num==1)return 1;
        if (num==2)return 2;
        return ways(num-1)+ways(num-2);
    }
}
