package Day23_Generic_Set_Tree;
/*
对于Set系列：HashSet，LinkedHashSet，TreeSet，底层是用Map创建
Set系列中的方法和collection类似,可以使用迭代器，增强for，foreach方法遍历
HashSet：无序，不重复无索引
LinkedHashSet：有序，不重复无索引
TreeSet：可排序，不重复无索引

Hash值：对象的整数表现形式
1.用什么方法获取Hash值？
2.获取自定义对象的时候默认获取到Hash值是什么？
3.什么是Hash碰撞？
4.一般情况下如何获取自定义对象的Hash值？

JDK8以前的底层：在JDK8之后采用数组+链表+红黑树
1.创建一个长度为16，默认加载因子为0.75（hashSet扩容时机）的数组，数组名为table
2.加入元素时：根据hash值与数组长度计算index：index=(arr.length()-1)&hash值，这里的值由于&，会使得计算的结果一定会小于数组长度
3.如果加入的元素hash值一样，而属性值不一样，那就挂在新元素下面（JDK8以前是头插法，与JDK8以后相反）
4.当链表长度大于8，数组长度大于64，就会把链表自动转成红黑树
*/

import java.util.HashSet;

public class Demo235 {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 23);
        Student student2 = new Student("张三", 23);
        Student student3 = new Student("李四", 24);
        Student student4 = new Student("王五", 25);

        System.out.println("1根据hashCode方法计算出来的整数，定义在Object类中，所有对象都可以调用");
        System.out.println("2.获取Hash值，默认使用地址值计算，但是一般情况下会重写HashCode方法，利用它对象内部属性计算哈希值");
        int hash1 = student1.hashCode();
        int hash2 = student2.hashCode();
        System.out.println(hash1+" "+hash2);

        System.out.println("3.在小部分情况下，会出现Hash碰撞：不同对象不同属性的对象计算出来的hash值一样");
        System.out.println("abd".hashCode()+" "+"acD".hashCode());

        System.out.println("4.当hashSet中存储自定义对象的时候请重写hashCode（得到哈希值以索引位置）与equals（比较对象属性，相同则不加入表）方法");
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student4);
        hashSet.add(student3);
        hashSet.add(student2);
        hashSet.add(student1);
        System.out.println(hashSet);
    }
}

