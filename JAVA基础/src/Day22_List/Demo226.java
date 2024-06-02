package Day22_List;

import java.util.ArrayList;
/*
ArrayList底层原理
1.ArrayList底层为数组
2.空参构造的集合，创建长度默认为0
3.添加第一个元素的时候，扩容为10
4.存满则自动扩容1.5倍（底层是原容量再加原容量右移一位之后的新容量）
5.果扩容之后也超过容量，则按照加入的元素量来扩容（有多少加多少
6.扩容使用arrays.copyOf,创建新的数组然后复制
看源码即可，顺着add方法往下走
）
*/
public class Demo226 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList);
    }
}
