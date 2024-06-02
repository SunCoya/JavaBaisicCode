package Day27_Exception_File;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
文件信息查看方法
1.判断是否存在,是文件还是文件夹
2.文件大小
3.文件路径
4.文件名
5.最后修改的时间
*/
public class Demo277 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day27_Exception_File\\MyTxt\\a.txt";
    public static void main(String[] args) {
        File f = new File(FILE_STRING);
        System.out.println("1.返回文件状态：是否存在，是文件还是文件夹");
        System.out.println(f.exists());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println("2.返回文件大小（length）（如果是文件夹，则返回不确定）");
        System.out.println(f.length());
        System.out.println("3.返回文件定义时的路径（getPath）与绝对路径（getAbsolutePath）");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println("4.返回文件名，也可以是文件夹名（getName）");
        f = new File("JAVA基础\\src\\Day27");
        System.out.println(f.getName());
        System.out.println("5.返回文件最后修改的时间");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(f.lastModified())));
    }
}
