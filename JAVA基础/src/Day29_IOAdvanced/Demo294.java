package Day29_IOAdvanced;
import java.io.*;
/*
案例：写入文件：运行代码的次数
1.在创建字符输出流的时候需要注意的事情？
会更新文件里面的数据
2.快速把基本数据类型变成字符串的方法？
数据+""
*/
public class Demo294 {
    final static String FILE_STRING = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\myini.txt";
    public static void main(String[] args) throws IOException {
        File file = new File(FILE_STRING);
        if (!file.exists())file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        if (line==null||line.length()==0){
            bw.write("1");
            System.out.println("欢迎使用本软件，第1次使用免费");
        }else {
            int i = (Integer.parseInt(line)+1);
            if (i>3){
                System.out.println("本软件只能免费使用三次,欢迎您注册会员之后使用");
            }else {
                bw.write(i+"");
                System.out.println("欢迎使用本软件，第"+i+"次使用免费");
            }
        }
        bw.close();
        br.close();
    }
}
