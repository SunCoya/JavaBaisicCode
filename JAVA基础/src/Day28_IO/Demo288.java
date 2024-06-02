package Day28_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
AutoCloseable：JDK7出现：特定情况下自动释放资源
实现这个接口的类可以在try-catch后自动释放资源
在try-catch中具体应该如何实现自动释放资源？
*/
public class Demo288 {
    final static String FILE_STRING2  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\aCopy.txt";
    public static void main(String[] args) {
        System.out.println("在try后加入括号（），在括号中写入需要定义的对象，对象用分号隔开");
        System.out.println("JDK9之后就可以在外面创建对象，括号里面只写变量名");
        try (FileInputStream fis = new FileInputStream(Demo281.FILE_STRING);
             FileOutputStream fos = new FileOutputStream(FILE_STRING2)) {
            fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
