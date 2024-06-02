package Day28_IO;

import java.io.FileOutputStream;
import java.io.IOException;

/*
1.IO流能够读写什么？
读写文件、网络中的数据

2.IO流主如何分类？
分为输入流（读），输出流（写）
又能分为字节流（所有文件）与字符流（文本）

3.主要哪一些抽象类？
InputStream，OutputStream操作字节，Reader，Writer操作字符

FileInputStream，FileOutputStream：操作本地文件的字节输入输出流
4.创建字节输出流时，如果路径不对会怎样？
5.如果文件已存在会怎样？
6.使用write方法写入文件的时候写入的数字代表的是什么？
7.除了写入单个字节，如何写入多个字节？
8.使用完字节输出流之后，最后一步是什么？
*/
public class Demo281 {
    final static String FILE_STRING  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\a.txt";
    public static void main(String[] args) throws IOException {
        System.out.println("4.如果路径不正确会报错");

        System.out.println("5.如果文件已经存在，会清空文件");
        FileOutputStream fos = new FileOutputStream(FILE_STRING);

        System.out.println("6.写的是97，实际写到本地文件的是ascii码表上的字符");
        for (int i = 'a'; i <= 'z'; i++) fos.write(i);

        System.out.println("7.定义数组写入文件，后面的参数代表截取的位置，在后面定义写入内存的时候会用到");
        byte[] arr = new byte[26];
        for (int i = 0; i < arr.length; i++) arr[i] = (byte) ('A' + i);
        fos.write(arr, 0, 26);

        System.out.println("8.最后一步释放资源");
        fos.close();
    }
}
