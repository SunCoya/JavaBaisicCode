package Day28_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
字符流
1.字符流的底层是？
底层就是字节流，添加了字符集的概念，适合操作纯文本文件

2.字符输入流与输出流每一次读取或写出多少数据？
输入流：按照规则读取，如果是英文就读一个字节，如果是中文就读三字节（根据不同编码方式）
输出流：按指定编码格式进行编码并且写到文件当中

3.一般使用什么类进行字符输入与输出？
使用Reader,Writer的实现类：FileReader与FileWriter来读写文件

读写缓存区
在字符流输入流底层，在-内存区-创建了一个8KB的缓冲区来存储数据，在第一次读数据的时候尽量装满，每次读取都从缓冲区中读取
每次读取都会判断缓冲区是否有数据可以读，没有数据读了就在文件中继续找数据放进去，新的数据替代老的数据（多出来的老数据不会清空）
在字符输出流底层，也会在-内存区-创建8KB的byte数组缓存数据

4.在读写缓存区中，数据什么时候会进行传输？有哪三种情况？
只有当：   数组满了 || flush()  ||  close()      才会把数据放进去

5.读写缓存区的位置在哪里？
区别读缓存区与写缓存区：读是一次性先拿，写是一次性后给，都是在内存中创建的空间！

FileReader与FileWriter:操作本地文件的字符输入输出流
使用reader与writer的操作与fis与fos情况相似，不同点：
1.字符输入与输出读取与写入的是字符还是字节？
2.字符输出流可以除了写入字符以及字符数组，还能写入什么？
3.在使用输入流的无参read方法时，返回的整数代表什么？
*/
public class Demo2810 {
    final static String FILE_STRING  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\b.txt";
    final static String FILE_STRING2  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\bCopy.txt";

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(FILE_STRING);
        FileWriter fileWriter = new FileWriter(FILE_STRING2);
        System.out.println("1.使用字符数组读取与写入");
        char[] chars = new char[1024];
        int len;
        System.out.println("2.除了传递char[],还能传递string去写入");
        while ((len = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0, len);
        }
        fileWriter.close();
        fileReader.close();

        fileReader = new FileReader(FILE_STRING);
        int i;
        System.out.println("3.返回的整数表示字符集上的数据，强转即可变成字符");
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
        fileReader.close();
    }
}
