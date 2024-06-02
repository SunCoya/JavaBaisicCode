package Day29_IOAdvanced;

import java.io.*;
import java.nio.charset.Charset;

/*
转换流是属于字符流，这个名字中，字符流字节流都占
是字符流与字节流之间的桥梁，字节流+转换流->字符流
1.创建转换流需要用到的参数是？
字节流
2.转换流属于字符流还是字节流？
字符流
3.转换流有哪些？
InputStreamReader与OutputStreamWriter
4.使用字节流创建转换流，再使用转换流创建字符缓冲流，需要close的流是哪一个呢？
最后创建的字符缓冲流

案例：两种方式指定字符编码读取数据
5.如何使用转换流指定读写字符？
6.如何使用字符流指定读写字符？
7.如何转换字符编码呢？
8.如何使用字节流读取一行数据呢？
*/
public class Demo295 {
    final static String src ="D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\GBK.txt" ;
    final static String dest = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\GBKCopy.txt";
    final static String dest_UTF = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\GBKToUTF.txt";
    public static void main(String[] args) throws IOException {
        int i;

        System.out.println("1.创建对象时指定字符编码，第二个参数使用字符串指定字符编码");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(src),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest), "GBK");
        while ((i=isr.read())!=-1) osw.write(i);
        osw.close();
        isr.close();

        System.out.println("2.JDK11之后可以使用FileReader,FileWriter指定字符编码，使用Charset的静态方法获取charset对象");
        FileReader fr = new FileReader(src, Charset.forName("GBK"));
        FileWriter fw = new FileWriter(dest, Charset.forName("GBK"));
        while ((i=fr.read())!=-1){
            fw.write(i);
        }
        fw.close();
        fr.close();

        System.out.println("3.案例：读GBK写UTF-8，在创建读写对象的时候指定即可");
        fr = new FileReader(src, Charset.forName("GBK"));
        fw = new FileWriter(dest_UTF);
        while ((i=fr.read())!=-1)fw.write(i);
        fw.close();
        fr.close();

        System.out.println("4.使用字节输入流读取一整行数据，字节流-转换流-缓冲字符流");
        FileInputStream fis = new FileInputStream(Demo292.FILE_STRING);
        isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
        br.close();
    }
}
