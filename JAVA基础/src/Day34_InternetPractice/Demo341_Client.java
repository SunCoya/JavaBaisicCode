package Day34_InternetPractice;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
使用TCP协议进行多发多收
1.在这个案例中，需要如何创建输入输出流？
使用的套接字对象与io流只用创建一次就行，通过循环进行多发多收
2.在这个案例中如何设置停止条件呢？
当客户端与服务器断开连接时(发送886)，服务端的读取也会结束
3.如何让接收端（服务端）使用字符缓冲流的readline方法接收数据？
4.在这个案例中，如果使用缓冲流发送数据应该注意什么？
*/
public class Demo341_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10086);
        OutputStream os = socket.getOutputStream();
        while (true) {
            String str = new Scanner(System.in).nextLine();
            //3.这里加一个换行方便readline读取数据，或者是用其他方法显示换行
            //4.在这里不使用缓冲流的write字符串方法，无法及时发出去..除非自己刷新
            os.write((str+"\n").getBytes());
            if ("886".equals(str)) break;
        }
        socket.close();
    }
}
