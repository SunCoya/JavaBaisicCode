package Day27_Exception_File;

import java.io.File;
/*
File对象与创建
1.File对象能够表示什么？一定需要是存在的吗？
2.有哪些方式能够创建File对象？
*/
public class Demo276 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File\\MyTxt";
    public static void main(String[] args) {
        System.out.println("1.file对象表示路径，可以是文件路径，也能是文件夹路径，可以不存在");

        String s = "a.txt";

        System.out.println("2.（1）使用一个String创建File对象");
        File file1 = new File(FILE_STRING);
        System.out.println(file1);

        System.out.println("（2）使用两个String创建File对象,自动补\\");
        File file2 = new File(FILE_STRING,s);
        //相当于
        file2 = new File(FILE_STRING+"\\"+s);
        System.out.println(file2);

        System.out.println("（3）使用一个file一个string创建对象");
        File file3 = new File(file1,s);
        System.out.println(file3);
    }
}
