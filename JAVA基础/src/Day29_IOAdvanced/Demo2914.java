package Day29_IOAdvanced;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Hutool工具包
https://hutool.cn/docs/#/
*/
public class Demo2914 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyHutool\\a.txt";
    public static void main(String[] args) {
        File file = FileUtil.file(FILE_STRING);
        //无需mkdirs再创建文件，全部路径创建
        File touch = FileUtil.touch(file);
        System.out.println(touch);

        //在文件中写入集合（换行）第四个参数确定是否续写，一行数据为集合中的一个元素
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"aaa","bbb","ccc");
        FileUtil.writeLines(arrayList,touch,"UTF-8",false);
        FileUtil.writeLines(arrayList,touch,"UTF-8",true);

        //读取文件到集合当中：指定编码
        List<String> list = FileUtil.readLines(touch, "UTF-8");
        System.out.println(list);
        list = FileUtil.readUtf8Lines(touch);
        System.out.println(list);
    }
}
