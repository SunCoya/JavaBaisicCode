package Day28_IO;

import java.io.FileInputStream;
import java.io.IOException;

/*
 finally：捕获异常完整形态
 1.finally后面的代码块的执行特点？
 2.如何在try-catch之后使用finally关闭流？
*/
public class Demo287 {
    final static String FILE_STRING  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\a.txt";
    public static void main(String[] args) {
        System.out.println("1.finally一定会执行：除非虚拟机停止");

        System.out.println("2.在try-catch代码块外设置io流为null");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_STRING);
            fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("在finally中，只有建立了传输通道（IO流不为null）才关闭");
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
