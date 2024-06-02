package Day29_IOAdvanced;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/*
commons-io工具包
Commons里面有许多工具类，这里只讲解io：Apache的IO操作工具包
可以看到jar包有五个，有后缀的是javadoc文档source资源以及test测试jar包
这里只要第一个:commons-io-2.11.0.jar
*/
public class Demo2913 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\Mycommons-io";
    public static void main(String[] args) throws IOException {
        //快速拷贝文件，拷贝文件夹，拷贝文件夹到指定目录，删除文件夹，清空文件夹
        FileUtils.copyFile(new File(FILE_STRING, "a.txt"), new File(FILE_STRING, "aCopy.txt"));
        FileUtils.copyDirectory(new File(FILE_STRING), new File(FILE_STRING + "2"));
        FileUtils.copyDirectoryToDirectory(new File(FILE_STRING), new File(FILE_STRING+"2"));
        FileUtils.deleteDirectory(new File(FILE_STRING+"2","Mycommons-io"));
        FileUtils.cleanDirectory(new File(FILE_STRING+"2"));
    }
}
