package Day29_IOAdvanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

//案例：使用字符缓冲流读文件，并排序写出
public class Demo293 {
    final static String CSB = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\csb.txt";
    final static String CSB_COPY = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\csbSort.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(CSB));
        ArrayList<String> arrayList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) arrayList.add(line);
        br.close();

        //这个comparingInt方法里面返回Comparator实现类，在这个方法中只要把对象转换成Integer类型即可
        arrayList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.split("\\.")[0])));

        BufferedWriter bw = new BufferedWriter(new FileWriter(CSB_COPY));
        for (String s : arrayList) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
