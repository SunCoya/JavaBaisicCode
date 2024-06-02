package Day29_IOAdvanced;

import java.io.*;
/*
字符缓冲流
1.字符缓冲输入流与缓冲输出流有什么特有方法，这种方法的返回值是什么？
2.使用readline方法时，会读取到换行符号吗？读到空行会返回什么？
3.使用什么方法能够新建一行呢？
*/
public class Demo292 {
    final static String FILE_STRING ="D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\b.txt";
    final static String FILE_STRING_COPY ="D:\\IDEACode\\demo1\\JAVA基础\\src\\Day29_IOAdvanced\\MyText\\bCopy.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_STRING));
        BufferedWriter bf = new BufferedWriter(new FileWriter(FILE_STRING_COPY));
        System.out.println("1.一次读一行，输出时不同的系统会有不同的换行方式，方法返回字符串");
        String line;
        System.out.println("2.换行符不会读取到,读到空行的时候返回的是空字符串");
        System.out.println("3.使用newline方法能够新建一行");
        while ((line=br.readLine())!=null){
            System.out.println(line+line.length());
            bf.write(line);
            if (line.length() != 0) bf.newLine();
        }
        bf.close();
        br.close();
    }
}
