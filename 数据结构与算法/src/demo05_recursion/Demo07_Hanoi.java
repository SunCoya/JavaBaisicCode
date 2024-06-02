package demo05_recursion;

import java.util.LinkedList;

/*
 * 汉诺塔
 * abc三根柱子
 * 一个圆盘直接移动
 * 两个圆盘，先移动小的到b，大的移动到c，最后把小的移动到c
 * 三个圆盘，先移动12到b，再移动3到c，最后把12移动到c
 * 四个同理，先把123移动到b，把4移动到c，最后把123移动到c
 * T(n)=2T(n-1)+c,T(1)=c,指数级别的算法
 * */
public class Demo07_Hanoi {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int i) {
        while (i > 0) {
            a.addLast(i);
            i--;
        }
    }

    public static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        int n  = 5;
        init(n);
        move(n,a,b,c);
    }


    //把n个盘子从a移动到C
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n==0)return;
        //把n-1个盘子丛a移动到b
        move(n-1,a,c,b);
        //把最后一个盘子丛a移动到c
        c.addLast(a.removeLast());
        print();
        System.out.println();
        //把n-1个盘子丛b移动到c
        move(n-1,b,a,c);
    }
}
