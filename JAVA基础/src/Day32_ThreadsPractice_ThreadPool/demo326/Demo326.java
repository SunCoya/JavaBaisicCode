package Day32_ThreadsPractice_ThreadPool.demo326;
/*
最大并行数：和CPU有关
Intel利用-超线程技术-使得每个核有两个线程
在设备管理器可以查看
1.如何获取最大能够使用的线程？

2.线程池开多大合适呢？
项目一般分为：CPU密集型（计算比较多）和IO密集型（读写文件多）
CPU密集型：
PU运算比较多，最大并行数+1（1是备用池）即可
IO密集型（大多数项目）：
最大并行数（8）*期望CPU利用率（占满100%）*[（计算时间+等待时间（等待IO流））/计算时间]这个需要用工具（thread dump）计算
*/
public class Demo326 {
    public static void main(String[] args) {
        System.out.println("2.使用Runtime.getRuntime().availableProcessors()获取当前最多能够使用的线程");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
