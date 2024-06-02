package Day29_IOAdvanced;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
压缩文件夹
1.在同一个目录下创建压缩文件夹，可以使用什么方法获取当前文件夹的父目录？
2.压缩文件夹所使用到的递归方法需要用到哪几个参数？
*/
public class Demo2912 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\实验文件夹\\day35-基础加强");
        System.out.println("1.在同一个目录下创建压缩文件夹,使用getParentPath获取当前文件夹的父目录");
        File dest = new File(src.getParentFile(),src.getName()+".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest), Charset.forName("GBK"));
        System.out.println("2.参数：传入源，使用的zos，父级目录");
        System.out.println("第二个参数是因为在递归中需要在不同的路径下去把文件压缩到同一个压缩文件中");
        System.out.println("第三个参数是因为new ZipEntry的时候，需要传递字符串：但是不能把完整路径传进去，故传递父级目录");
        System.out.println("在这里因为我需要在zip文件夹里面直接放入src的子文件夹，故先遍历子文件夹，就改写了先判断是否为文件夹的写法。");
        toZip(src, zos, "");
        zos.close();
    }


    public static void toZip(File src, ZipOutputStream zos, String fatherName) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                //zip中文件的路径
                String str = fatherName + file.getName() + "\\";
                //放入entry即可创建目录
                zos.putNextEntry(new ZipEntry(str));
                toZip(file, zos, str);
            }
            //下次省else语句的时候还是悠着点吧
            else {
                //是文件
                zos.putNextEntry(new ZipEntry(fatherName + file.getName()));
                FileInputStream fis = new FileInputStream(file);
                int len;
                byte[] bytes = new byte[1024];
                while ((len = fis.read(bytes)) != -1) zos.write(bytes, 0, len);
                fis.close();
                zos.closeEntry();
            }
        }
    }
}
