package Day34_InternetPractice;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
/*
实现服务端对客户端消息的接收与反馈
问题：关掉由socket获取的io流时也会关闭socket，如何解决？
可以使用socket类中的shutdown...方法关闭输入或者输出流
*/
public class Demo342_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10086);
        socket.getOutputStream().write("客户端向服务端写数据!".getBytes());
        socket.shutdownOutput();
        System.out.println(new String(socket.getInputStream().readAllBytes()));
        socket.close();
    }
}
