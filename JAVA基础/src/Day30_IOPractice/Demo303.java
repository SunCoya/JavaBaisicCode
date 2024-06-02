package Day30_IOPractice;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//准备数据部分：每行数据加-1
public class Demo303 {
    final static String FILE_STRING2 = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day30_IOPractice\\MyText\\name2.txt";
    public static void main(String[] args) throws IOException{
        File file = new File(Demo301.FILE_STRING);
        File file2 = new File(FILE_STRING2);
        List<String> list = new ArrayList<>();
        FileUtil.readUtf8Lines(file, list);
        list = list.stream().map(s -> s + "-1").collect(Collectors.toList());
        FileUtil.writeUtf8Lines(list, file2);
    }
}
