package Day27_Exception_File;

import java.io.File;
import java.io.IOException;
//案例：获取文件夹里面的文件大小,需要注意不要对文件夹使用length方法
public class Demo2713 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\33428\\Videos");
        System.out.println(myForEach(file));
    }
    public static Long myForEach(File file){
        if (file.isFile()){
            System.out.println(file);
            return file.length();
        }
        File[] files = file.listFiles();
        if (files==null)return 0L;
        long sum = 0L;
        for (File listFile : files) sum += myForEach(listFile);
        return sum;
    }
}
