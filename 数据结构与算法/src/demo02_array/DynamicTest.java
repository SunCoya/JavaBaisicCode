package demo02_array;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/*
1.Java中的数组；
    8字节markword（哈希码，垃圾回收信息，锁信息）
    4字节类指针
    4字节数组大小记录
    数组元素+对齐字节（java所有对象大小都是8字节整数倍）
   二维数组：使用四字节记录其中的一个一维数组的位置，在内存布局上是连续的
    内存与cpu间通过缓存提高存取效率，一次记录一个缓存行cache line，二维数组遍历一行一行地遍历比一列一列遍历更加快

2.数组随机访问时间复杂度是O(1),和数据规模没有关系

动态数组：Java中已经实现的动态数组ArrayList
实现动态数组：动态数组基本功能
getSize,add,remove,foreach,扩容
*/
public class DynamicTest {
    static DynamicArray array = new DynamicArray();
    static {
        array.addLast(0);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.add(0, 5);
    }
    @Test
    public void test1(){
        array.foreach(System.out::print);
        array.foreach(System.out::print);
        for (Integer i : array) System.out.print(i);
        System.out.println();
        array.stream().forEach(System.out::print);
    }
    @Test
    public void test2(){
        int remove = array.remove(3);
        System.out.println("删除的元素是"+remove);
        array.forEach(System.out::print);
        //使用断言判断两个集合内容是否一样
        assertEquals(2,remove);
        assertIterableEquals(List.of(5,0,1,3,4),array);
    }

    @Test
    public void test3(){
        for (int i = 6; i <= 10; i++) array.addLast(i);
        array.forEach(System.out::print);
    }
}


