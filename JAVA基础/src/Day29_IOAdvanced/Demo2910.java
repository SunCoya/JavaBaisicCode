package Day29_IOAdvanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
1.解压缩流与压缩流属于什么流？
解压缩流读与压缩流写属于字节流

2.压缩流中每一个文件在Java中是什么对象？
压缩包里面的每一个文件在Java中都是ZipEntry对象

3.解压缩流与压缩流的类名？
ZipInputStream与ZipOutputStream

案例：解压
解压就是把每一个ZipEntry按照层级结构拷贝到另一个文件当中
1.在windows系统中如何创建解压缩流？需要注意什么？
2.如何获取解压缩流中的每一个文件？
3.使用什么方法判断zipEntry是文件还是文件夹？
4.ZipEntry的toString方法与getName方法返回值是怎么样的？
5.写入文件的时候如何使用zipInputStream,读取的是什么？
6. 当压缩包中的一个文件解压完毕，应该做什么？
*/
public class Demo2910 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Java基础\\day35-基础加强（反射，动态代理）.zip");
        File dest = new File("D:\\实验文件夹\\day35-基础加强");

        System.out.println("1.创建解压缩流：用来读取压缩包的数据，依然需使用基本的字节流，需要根据系统指定编码规则");
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src), Charset.forName("GBK"));

        System.out.println("2.使用ZipEntry来获取解压缩流的文件,获取不到则返回为空。");
        ZipEntry zipEntry;
        System.out.println("3.使用isDirectory方法判断ZipEntry是文件还是文件夹");
        System.out.println("4.ZipEntry中toString方法与getName方法返回值一致");
        System.out.println("5.使用zipInputStream中的read方法读取数据，读取的是当前zipEntry中的内容");
        System.out.println("6.压缩一个文件后记得把当前的zipEntry关闭掉，使用解压缩流中的closeZipEntry方法");
        while ((zipEntry=zis.getNextEntry())!=null){
            System.out.println(zipEntry);
            //创建文件夹,这里使用getName与toString都一样
            if(zipEntry.isDirectory())
                new File(dest,zipEntry.getName()).mkdirs();
            else {
                //创建文件：需要读取文件夹，存放到文件中
                File file = new File(dest,zipEntry.getName());
                FileOutputStream fos = new FileOutputStream(file);
                int len;
                byte[] bytes = new byte[1024];
                //这里的读取是在当前entry下
                while ((len=zis.read(bytes))!=-1)fos.write(bytes,0,len);
                fos.close();
                //压缩包中的一个文件处理完毕
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
