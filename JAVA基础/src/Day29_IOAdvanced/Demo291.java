package Day29_IOAdvanced;

import java.io.*;

/*
字节缓冲流
前面的学习是基本流
1.有哪些缓冲流？
带有缓冲区的缓冲流：BufferedInputStream||BufferedOutputStream||BufferedReader||BufferedWriter

2.缓冲流有多少字节的默认缓冲区？
字节缓冲流底层自带8KB的缓冲区：注意，缓冲流是高级流的一种，对基本流做了数据的包装
后面的两个由于在基本流中也有8KB的缓冲区，提高效率不太明显

3。创建缓冲流对象需要传入什么参数？缓冲流相对于基本流有什么特点？
创建对象需要关联基本流，读写数据的依然是基本流，缓冲流的读取效率更高，操作与基本流相似

4.缓冲字节流的传输速度一定比基本字节流的传输速率快吗？
不一定，可以看下面的运行结果：当同为一次性传输8kb的数据的时候，传输速度相近。
如果在底层一次只读取一个字节，有缓冲区的字节流的速度依旧会慢于传递比较大的数组的无缓冲区的字节流的速度

5.在new缓冲字节流时，第二个参数表示什么？
*/
public class Demo291 {
    final static String src = "C:\\Users\\33428\\Videos\\haniwa\\いつだって戦ってる.mp4";
    final static String dest = "C:\\Users\\33428\\Desktop\\Haniwa.mp4";
    public static void main(String[] args) throws IOException {
        int i, len;
        long time1, time2;
        byte[] bytes = new byte[8192];
        time1 = System.currentTimeMillis();
        System.out.println("5.设置第二个参数以手动设置缓冲区大小");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src),8192);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        System.out.print("一次在底层传输一个字节（有缓冲区）:");
        while ((i = bis.read()) != -1) bos.write(i);
        bos.close();
        bis.close();
        time2 = System.currentTimeMillis();
        System.out.println("花费时间"+(time2 - time1)/1000.0+"秒");


        time1 = System.currentTimeMillis();
        bis = new BufferedInputStream(new FileInputStream(src));
        bos = new BufferedOutputStream(new FileOutputStream(dest));
        System.out.print("一次在底层传输8192字节大小数组（有缓冲区）：");
        while ((len = bis.read(bytes)) != -1) bos.write(bytes, 0, len);
        bos.close();
        bis.close();
        time2 = System.currentTimeMillis();
        //传递数组总比传递一个字节花费时间少
        System.out.println("花费时间"+(time2 - time1)/1000.0+"秒");


        time1 = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        System.out.print("一次在底层传输8192字节大小数组（无缓冲区）");
        while ((len = fis.read(bytes)) != -1) fos.write(bytes,0,len);
        fis.close();
        fos.close();
        time2 = System.currentTimeMillis();
        System.out.println("花费时间"+(time2 - time1)/1000.0+"秒");
    }
}
