package Day27_Exception_File;
import java.io.File;
import java.util.Arrays;
/*
获取File下的内容并遍历
1.使用什么方法获取指定目录下的file数组？
2.不存在该目录时方法会返回什么？
3.为文件时方法会返回什么？
4.位空文件夹时该方法会返回什么？
5.该方法能够获取隐藏文件夹吗？
6.如何获取可用的系统根？
7.使用什么方法获取指定目录下的文件数组？（String类型）
8.在创建文件时如何过滤内容？
*/
public class Demo279 {
    public static void main(String[] args) {
        File file = new File("D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File");
        System.out.println("1.获取文件与文件夹的数组");
        File[] files = file.listFiles();
        System.out.println(files);

        System.out.println("2.不存在则返回空");
        file = new File("Java基础\\src\\Day1");
        System.out.println(file.listFiles());

        System.out.println("3.为文件时也会返回为空");
        file = new File("D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File\\Demo271.java");
        System.out.println(file.listFiles());

        System.out.println("4.为空文件夹时返回为空数组");
        file = new File("D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File\\MyTxt\\directory1");
        System.out.println(Arrays.toString(file.listFiles()));

        System.out.println("5.除此之外，能够获取到隐藏文件夹，有些文件夹可能权限不足无法访问,返回为空");

        System.out.println("6.列出可以用的文件系统根");
        System.out.println(Arrays.toString(File.listRoots()));

        System.out.println("7.获取目录下的文件名（String类型的）");
        file = new File("D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File");
        System.out.println(Arrays.toString(file.list()));

        System.out.println("8.可以在创建文件时传入接口实现类过滤内容");
        file.listFiles((myFile)->myFile.getName().startsWith("D"));
    }
}
