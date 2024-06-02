package Day30_IOPractice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
1.properties配置文件的两个特点？
1.后缀名为properties
2.以键值对的形式存储

2.在Java中，Properties是一个什么样的类呢？
为Map的一个实现类，继承于HashTable

3.Properties类里面有什么特别的方法？
里面有特有方法store（）可以把数据按照键值对的形式写到配置文件中，load（）能够读取数据转换成集合

4.定义Properties时需要限定泛型吗？

5. 使用store方法与load方法时分别需要传入什么参数？

拼图小游戏存档读档功能增加，配置文件（配置广告位）增加
每日一记就不写了
*/
public class Demo305 {
    final static String File_String = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day30_IOPractice\\MyProperties\\a.properties";
    public static void main(String[] args) throws IOException {
        System.out.println("4.定义Properties不需要说明泛型，可以添加任意数据类型，默认为Object，一般只添加字符串");
        Properties properties = new Properties();
        properties.put("aaa","111");
        properties.put("bbb","222");
        properties.put("ccc","333");
        properties.put("ddd","444");
        System.out.println("5.使用store方法时需要传入字符输出流与备注，使用load方法时需要传入字符输入流");
        properties.store(new FileWriter(File_String), "myProperties");
        properties.clear();
        properties.load(new FileReader(File_String));
        System.out.println(properties);
    }
}
