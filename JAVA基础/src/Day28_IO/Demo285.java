package Day28_IO;

import java.io.FileInputStream;
import java.io.IOException;

/*
案例：使用read一次读取一个字节数组的数据，每次读取尽量把数组装满
1.使用read读取数组时，返回值是什么？
2.在读完数据之后，再次读取数据会替代之前的老数据，老数据会被全部清空吗？
3.全部读取完之后会返回什么？
4.如何解决掉多余的老数据呢？
*/
public class Demo285 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(Demo281.FILE_STRING);
        byte[] bytes = new byte[50];

        System.out.println("1.使用read读取数组的返回值代表本次读取的数据个数");
        int len = fis.read(bytes);
        String MyStr = new String(bytes);
        System.out.println("本次读取到的数据："+MyStr);
        System.out.println("本次读取的数据量："+len);

        System.out.println("2.读完的数据会覆盖之前的数据：但是不会全部清除");
        len = fis.read(bytes);
        MyStr = new String(bytes);
        System.out.println(MyStr);
        System.out.println("本次读取了数据量："+len);

        System.out.println("3.全部读取完之后再读取会返回-1，数据依旧是老数据");
        len = fis.read(bytes);
        MyStr = new String(bytes);
        System.out.println(MyStr);
        System.out.println("本次读取了数据量："+len);

        System.out.println("4.解决办法：使用len进行参数传递，如new String(bytes,0,len)");
        fis.close();
    }
}
