package Day27_Exception_File;

import java.io.File;
import java.io.IOException;
//案例：遍历文件夹：需要注意无权限访问的文件夹，返回数组时会返回为空
public class Demo2710 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\33428\\AppData\\Local\\Microsoft");
        myForEach(file);
    }
    public static void myForEach(File file){
        if (file.isFile()){
            System.out.println(file);
            return;
        }
        File[] files = file.listFiles();
        if (files==null)return;
        for (File listFile : files) myForEach(listFile);
    }
}
