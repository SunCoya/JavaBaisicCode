package Day35_Reflect_DynamicAgent;
/*
反射：允许对封装类的成员变量、构造方法、成员方法获取出来然后进行操作，或者获取到如修饰符，名字等更加详细的信息
没有反射怎么拿？使用IO流！但是比较麻烦，这里就用反射咯

1.获取Class的有哪三种方式？
    1.Class.forName("全类名")
    2.类名.class
    3.对象.getClass()
对应三个不同的阶段
    1.源代码：编译时期
    2.加载阶段：在内存当中的时候
    3.运行阶段：已经有对象了
2.这三种方法获取的是什么对象？
*/
public class Demo351 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("（1）获取Class的第一种方式：需要传入全类名的字符串：包含包名，最为常用");
        System.out.println("IDEA中获取：选择类名，然后右键选择copy_Reference");
        Class<?> class1 = Class.forName("Day35_Reflect_DynamicAgent.Demo351");
        System.out.println(class1);

        System.out.println("（2）获取Class的第二种方式，通过类名调用");
        System.out.println("第二种则是多用于作为参数作为传递：比如当作锁");
        Class<?> class2 = Demo351.class;

        System.out.println("（3）获取Class的第三种方式，通过对象调用，也是获取的字节码文件");
        Class<?> class3 = new Student().getClass();

        System.out.print("2.前两个类对象都是获取的字节码文件，是同一个对象：");
        System.out.println(class2==class1);
    }
}
