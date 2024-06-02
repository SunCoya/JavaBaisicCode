package Day28_IO;

import java.io.FileOutputStream;
import java.io.IOException;

/*
使用输出流续写，输出字符串，换行
1.如何续写？
2.如何输入字符串？
3.在使用字节输出流输出成文件时，如何换行？
*/
public class Demo282 {
    public static void main(String[] args) throws IOException {
        System.out.println("1.续写只要在定义字节输出流的时候把第二个参数设置true即可");
        FileOutputStream fos = new FileOutputStream(Demo281.FILE_STRING,true);

        System.out.println("2.把字符串变成字节数组换行操作");
        System.out.println("3.使用\\r\\n都可以换行（三个操作系统的换行符都不一样，java帮忙处理了）");
        fos.write("\nHello IO!".getBytes());
        fos.write("\r666".getBytes());
        fos.close();
    }
}
