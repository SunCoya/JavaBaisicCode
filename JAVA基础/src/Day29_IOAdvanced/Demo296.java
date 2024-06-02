package Day29_IOAdvanced;

import java.io.*;

/*
序列化流（输出）反序列化流（输入）：属于字节流
可以把Java中的对象写到本地文件中，看不懂改不了

1.需要序列化的对象有什么要求？
序列化对象需要让javabean类实现serializable接口，标记型接口，之前还有一个Cloneable

2.对于实现serializable接口的实现类，如果没有指定其序列号其序列版本号是不变的吗？序列化和反序列化需要版本号相同吗？
Java会根据类里面的所有内容去生成一个序列号，如果修改的类的代码，版本号会变化，序列化和反序列化的版本号需要保持一致

3.序列化版本号如何定义？
版本号起名规则：私有long常量，名字必须叫serialVersionUID：可以设置一下IDEA自动提示与生成

4.不想序列化到本地的变量该如何处理？
不想序列化到本地的成员变量使用transient修饰符修饰（瞬态）

5.序列化与反序列化的类名？
ObjectInputStream与ObjectOutputStream

6.如何定义序列化与反序列化流？

7.序列化与反序列化应该使用什么方法？
*/
public class Demo296 {
    final static String str = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyObject\\a.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu  = new Student("SunCoya",20,"沅江");
        System.out.println("1.使用字节基本流创建序列化与反序列化对象");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str));
        System.out.println("1.使用writeObject方法序列化对象，使用readObject方法反序列化对象");
        oos.writeObject(stu);
        stu = (Student) ois.readObject();
        System.out.println(stu);
        oos.close();
        ois.close();
    }
}
