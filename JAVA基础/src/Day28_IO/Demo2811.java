package Day28_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//案例：拷贝文件夹，包括其子文件夹
public class Demo2811 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\Java基础\\Java基础-资料");
        File file2 = new File("D:\\实验文件夹");
        copy(file1, file2);
    }
    public static void copy(File file1, File file2) throws IOException {
        //创建新的文件名字，看情况创建文件或者文件夹，这里使用getName获取文件名或者是文件夹名，不需要使用split方法
        File file1Copy = new File(file2, file1.getName());
        if (file1.isFile()) {
            //是文件，所以要拷贝，这里不需要创建文件：输出流自动创建！
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file1Copy);
            byte[] bytes = new byte[1024 * 1024];
            int len;
            if ((len = fis.read(bytes)) != -1)fos.write(bytes,0,len);
            fos.close();
            fis.close();
        }else {
            //不是文件：所以要创建文件夹
            file1Copy.mkdirs();
            //遍历file1
            for (File file : file1.listFiles()) {
                copy(file,file1Copy);
            }
        }
    }
}
