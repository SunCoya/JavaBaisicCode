package Day28_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//案例：修改文件中的数据，再排序数据
public class Demo2813 {
    final static String FILE_STRING  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\c.txt";
    final static String FILE_STRING2  = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day28_IO\\MyText\\cCopy.txt";
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(FILE_STRING);
        StringBuilder sb= new StringBuilder();
        int i;
        //如果是用数组的方式读取，一定要记得要限制范围
        while((i=reader.read())!=-1) sb.append((char)i);
        reader.close();
        //可以先把read的操作全部做完再创建writer
        FileWriter writer = new FileWriter(FILE_STRING2);
        String str= Arrays.toString(Arrays.stream(sb.toString().split("-"))
                .map(Integer::parseInt).sorted().toArray(Integer[]::new))
                //这里对于数据只用改动部分（只需要替换字符与去除第一个与最后一个字符），无需StringBuilder再遍历了，尽量简化你的操作
                .replace(", ","-");
        writer.write(str.substring(1,str.length()-1));
        writer.close();
    }
}
