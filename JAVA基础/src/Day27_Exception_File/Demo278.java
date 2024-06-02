package Day27_Exception_File;

import java.io.File;
import java.io.IOException;

/*
文件操作方法
1.如如何创建新文件？如果文件已存在会发生什么？如果路径错误会发生什么？
2.如何创建单级目录？
3.如何创建多级目录？
4.如何删除文件？
5.如何删除文件夹？当文件夹里面有文件时能删除文件夹吗？
*/
public class Demo278 {
    public static void main(String[] args) throws IOException {
        System.out.println("1.创建新文件：1.如果文件已经存在，则创建失败 2.如果找不到路径会报错");
        File file1 = new File(Demo276.FILE_STRING,"b.txt");
        System.out.println(file1.createNewFile());

        System.out.println("2.创建单级目录");
        File file2 = new File(Demo276.FILE_STRING,"directory1");
        System.out.println(file2.mkdir());

        System.out.println("3.创建多级目录（创建单级肯定也可以）");
        File file3 = new File(Demo276.FILE_STRING,"directory2\\A");
        System.out.println(file3.mkdirs());

        System.out.println("4.删除文件");
        System.out.println(file1.delete());

        System.out.println("5.删除文件夹：有内容就删不掉");
        System.out.println(new File(Demo276.FILE_STRING).delete());
        System.out.println(file3.delete());
    }
}
