package Day29_IOAdvanced;

import java.io.*;
import java.nio.charset.Charset;

/*
打印流：只能写，不能读
1.打印流分为哪两种？用什么类名表示？
分为字节打印流和字符打印流：PrintStream与PrintWriter

2.打印流的特有方法？

3.如何创建打印字节流与打印字符流？

4.平常使用的输出语句，out是一个什么样的变量？默认指向哪里？
*/
public class Demo298 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\printStreamAndWriter.txt";
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream(FILE_STRING);
        ps = new PrintStream(new FileOutputStream(FILE_STRING));
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(FILE_STRING)),true,"GBK");
        ps.println("1.打印流的特有方法有：printf，println，print方法");
        ps.println("2.字节打印流在底层通过字节流创建，有多种创建方式（传递字符串或io字节流对象）");
        ps.println("传递参数能够使其自动刷新和指定字符串的输出编码");
        ps.close();

        PrintWriter pw = new PrintWriter(new FileWriter(FILE_STRING, Charset.forName("GBK"),true),true);
        pw.println("字符打印流与字节打印流类似，需要传递字符流，能够指定自动刷新");
        pw.println("3.System中的out变量是一个PrintString静态变量，在虚拟机启动时由虚拟机创建，默认指向控制台");
        pw.close();
    }
}
