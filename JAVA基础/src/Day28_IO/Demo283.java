package Day28_IO;

import java.io.FileInputStream;
import java.io.IOException;

/*
读取整个文件：一个一个字节读取
1.使用read方法读取数据时，返回的参数代表什么？
2.如何使用while循环读取整个文件？
*/
public class Demo283 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(Demo281.FILE_STRING);
        int i;
        System.out.println("1.使用read方法读取资源，返回值为int类型的读到的字节，到最后返回-1");
        System.out.println("2.在while循环里面使用赋值语句，注意在这里赋值的语句优先级较低，需要加括号");
        while ((i=fis.read()) != -1)  System.out.print((char) i);
        fis.close();
    }
}
