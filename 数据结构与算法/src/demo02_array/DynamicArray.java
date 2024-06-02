package demo02_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;//当前存储数据个数
    private int capacity = 8;//最多存储数据个数
    //懒惰初始化
    private int[] array = {};

    //获取当前数据个数
    public int getSize() {
        return size;
    }

    //根据索引获取数据
    public int get(int index) {
        return array[index];
    }

    //插入到数组最后
    public void addLast(int element) {
        add(size, element);
    }

    //插入到任意位置:索引需要小于等于size
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Error：输入了错误的插入索引");
            return;
        }
        checkAndGrow(index);
        //向后移动数组
        if (index < size)
            System.arraycopy(array, index, array, index + 1, size-index);
        array[index] = element;
        size++;
    }

    //根据索引删除：返回被删除的那一个元素
    public int remove(int index) {
        if (index<0||index>=size){
            System.out.println("不合规的index！");
            return 0;
        }
        //需要提前记录！
        int remove = array[index];
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return remove;
    }

    //遍历数据，使用函数式接口Consumer，注意根据size遍历，不要把数组全部遍历
    //需要参数，无返回值，使用Consumer更合适（这一部分可以去了解java四大函数式接口）
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }
    @Override
    //在Iterator接口中自带default类型的forEach方法
    //在完成这个方法之后，测试方法中就能使用增强for去遍历
    public Iterator<Integer> iterator() {
        //需要创建一个Iterator对象返回
        return new Iterator<>() {
            //回归本质：匿名内部类相当于创建一个MyIterator.class，实现了Iterator接口，当然可以定义变量
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }
            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }
    //返回stream流
    public IntStream stream(){
        return Arrays.stream(Arrays.copyOfRange(array, 0, size));
    }

    private void checkAndGrow(int index) {
        if (size==0)array = new int[capacity];
        if (size==capacity){
            System.out.println("扩容时间到,*1.5倍");
            capacity += capacity>>1;
            int[] newArray = new int[capacity+capacity>>1];
            System.arraycopy(array,0,newArray,0, size);
            array=newArray;
        }
    }
}
