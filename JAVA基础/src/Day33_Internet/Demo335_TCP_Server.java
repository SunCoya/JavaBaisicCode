package Day33_Internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


//服务器端
public class Demo335_TCP_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("1.创建服务端的ServerSocket对象,端口需要与客户端需要连接的端口保持一致");
        ServerSocket ss = new ServerSocket(10000);

        System.out.println("2.调用accept方法等待客户端连接,返回Socket对象");
        System.out.println("没有人连就会卡死在这一行代码，需要在这里获取Socket对象");
        Socket socket = ss.accept();

        System.out.println("3.获取输入流");
        InputStream is = socket.getInputStream();
        System.out.println("在这里一次性获得了所有的字节，因为此处比较简单，别的情况下中文可能会乱码，可以使用转换流");
        byte[] bytes  = is.readAllBytes();
        System.out.println(new String(bytes));

        System.out.println("4.关闭socket对象，相当于断开与客户端的连接");
        socket.close();
        System.out.println("5.关闭serverSocket对象，相当于终结服务器资源");
        ss.close();
    }
}
