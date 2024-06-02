package Day30_IOPractice;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;
/*
使用Hutool工具一次性获取网页内容，利用正则表达式一次性处理数据，和前面的自己写的代码功能一样！
1.如何使用糊涂包一次性获取全部的网页内容？
2.如何利用糊涂包一次性解析所有网页内容，并返回符合条件的集合？
3.使用FileUtil工具时对于输出文件路径有什么要求吗？
*/
public class Demo302 {
    public static void main(String[] args) {
        System.out.println("1.使用HttpUtil的get方法获取所有的网页源代码");
        String str = HttpUtil.get(Demo301.WEB_STRING1);
        System.out.println("2.使用ReUtil中的findAll方法传入regex，string，组号即可获取相应的字符串集合");
        List<String> familyNameTempList = ReUtil.findAll("(....)[，。]",str,1);
        System.out.println("3.糊涂包生成的文件会相对于class文件生成：存在out文件中，需要补全路径");
        FileUtil.writeLines(familyNameTempList,Demo301.FILE_STRING,"UTF-8");
    }
}
