package demo23_DP;
/*
* 01背包：动态规划
* 背包最高接受重量：10
* 编号  重量    价格  简称
* 0     4       160     A
* 1     8       240     R
* 2     5       30      S
* 3     1       1000    D
*
* 其动态规划思想：
* 纵轴物品，横轴重量
*       0       1       2       3       4       5       6       7       8       9       10
* 0     0       0       0       0       A       A       A       A       A       A       A
* 1     0       0       0       0       A       A       A       A       R       R       R  好，这里的R进入如何判断呢？
* 2     0       0       0       0       A       A       A       A       R       R       R  这里到9判断A+S与R
* 3     0       D       D       D       D       DA      DA      DA      DA      DR      DR
* */
public class Demo03_KnapsackProblem {
}
