package Day28_IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/*
1.字符集详解
Windows中文系统使用的编码方式是什么？系统显示为什么？
windows中文系统使用的就是GBK（国家标准扩展，是一种编码方式），系统显示为ANSI

2.在GBK编码中，汉字用多少个字节存储？一般以0开头还是1开头？
在GBK中一个汉字用两个字节存储，英文二进制0开头，中文1开头

3.UniCode字符集：包含世界大多数文字

4.UTF-数字，后面的数字代表什么意思，在UTF-8中，中日韩文一般用多少个字节存储？
UTF-16:（UniCode Transfer Format）最常用的就是转成16比特位（两字节）
UTF-32：统一32字节保存
UTF-8:用1-4字节保存，使用的最多，英文一个字节，中日韩三个字节

5.在UTF-8中，1-4位字节的数据的每个字节的开头有什么特点？
一个字节的第一位是0（留下7位自由选择）
两个字节的前两位是110，后面字节的全是10开头（留下11位自由选择）
三个字节前两位是1110，后面字节全是10开头（留下16位自由选择）
上面这样做是为了区别一个字符开始的字节在何处

6.UTF-8如何对汉字进行编码？
汉字要先查询Unicode，再转换成UTF-8编码

7.乱码的原因大多数是因为什么？
乱码原因，很大原因是编码解码方式不一样：如GBK一次读汉字读两个字节，而UTF-8一次读三个字节

8.如何避免乱码？
避免乱码：不要用字节流读取文本文件，编码解码使用同一字符集与同一编码方式


使用使用String与byte数组进行编码解码
1.如何把字符串编码变成字节数组？
2.如何把字节数组解码变成字符串？
3.上述两个操作如何指定编码与解码方式？
*/

public class Demo289 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "元神，启动！";
        System.out.println("1.使用String的getBytes方法，把要存储的数据进行编码：以默认方式（UTF-8）编码");
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        System.out.println("2.在字符串中的构造方法中传入字节数组解码：把字节数据变成想要查看的内容，默认UTF-8");
        System.out.println(new String(bytes,"UTF-8"));

        System.out.println("3.getBytes方法中传入参数代表编码方式");
        bytes = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes));

        System.out.println("4.传入第二个参数代表解码方式");
        System.out.println(new String(bytes,"GBK"));
    }
}
