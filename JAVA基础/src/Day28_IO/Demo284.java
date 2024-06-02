package Day28_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
拷贝文件
1.如何拷贝文件？
2.一次只读写一个字节有什么缺点？
3.对于输入流与输出流的关闭顺序有什么规范吗？
*/
public class Demo284 {
    final static String FILE_STRING  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\";
    public static void main(String[] args) throws IOException {
        System.out.println("1.同时使用fis与fos可以拷贝文件");
        FileInputStream fis = new FileInputStream(FILE_STRING+"a.txt");
        FileOutputStream fos = new FileOutputStream(FILE_STRING+"aCopy.txt");

        System.out.println("2.一次只读写一个字节，速度非常慢");
        int b;
        while ((b = fis.read())!=-1){
            System.out.print(b+" ");
            fos.write(b);
        }
        System.out.println();
        System.out.println("3.先开的资源后关闭");
        fos.close();
        fis.close();
    }
}
