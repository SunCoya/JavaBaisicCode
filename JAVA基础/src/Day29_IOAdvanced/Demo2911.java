package Day29_IOAdvanced;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/*
案例：压缩一个文件
压缩：把每一个文件或者文件夹看成ZipEntry对象放到压缩包中
1.如何创建压缩流？
2.如何创建ZipEntry对象？传入的参数可以是多级目录吗？
3.写入压缩文件前需要做什么？
4.zos与zis输出与写入的文件由什么决定？
*/
public class Demo2911 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\Java基础\\Java基础-资料\\阿里巴巴Java开发手册终极版v1.3.0.pdf");
        File dest = new File("D:\\实验文件夹\\阿里巴巴开发手册.zip");
        System.out.println("1.创建压缩流去关联压缩包，也要记得指定编码");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest), Charset.forName("GBK"));

        System.out.println("2.创建zipEntry对象：表示每一个文件或者文件夹，里面可以传入多级目录");
        ZipEntry zipEntry = new ZipEntry("阿里巴巴Java开发手册终极版v1.3.0.pdf");

        System.out.println("3.写入压缩文件前需要把zipEntry对象放到压缩包当中");
        zos.putNextEntry(zipEntry);

        System.out.println("4.zos写的是最近put的entry，上面的zis读的是最近打开的entry");
        FileInputStream fis = new FileInputStream(src);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!=-1)zos.write(bytes,0,len);
        fis.close();
        zos.closeEntry();
        zos.close();
    }
}
