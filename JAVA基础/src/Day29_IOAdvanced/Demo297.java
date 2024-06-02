package Day29_IOAdvanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


//如何序列化与反序列化多个对象？
public class Demo297 {
    static String str = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyObject\\multiObjects.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("zhangsan",23,"nanjin");
        Student s2 = new Student("lisi",24,"chongqing");
        Student s3 = new Student("wangwu",25,"wuhan");
        System.out.println("在读对象的时候读完的时候再读会报错,所以只传一个对象进去：ArrayList");
        ArrayList<Student> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,s1,s2,s3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str));
        oos.writeObject(arrayList);
        for (Student student : (ArrayList<Student>) ois.readObject())
            System.out.println(student);
        oos.close();
        ois.close();
    }
}
