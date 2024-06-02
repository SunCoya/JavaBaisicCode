package Day33_Internet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP在通信的两端各建立一个Socket对象：通信之前要确保连接已经建立
通过IO流来进行网络通信

三次握手协议建立连接
1.客户端向服务器发送请求等待服务器确认
2.服务器向客户端返回请求，告诉客户端收到了请求
3.客户端向服务器再次发出确认消息，连接建立
TCP设计成三次握手的目的就是为了避免重复连接，因为会有多次请求的情况

四次挥手协议断开连接：需要确保连接通道里面的数据已经全部处理完（多的那一步）
1.客户端向服务器发送取消连接请求
2.服务端向客户端返回响应，表示已经收到了客户端的请求，需要等服务器处理完最后的数据
3.一旦处理完成，服务器向客户端再次发出确认需要取消连接的消息
4.客户端再次发送确认消息，取消连接

客户端
1.创建客户端的Socket对象与指定的服务端连接Socket(IP,port)
2.获取输出流 getOutputSteam
3.释放资源
*/
public class Demo335_TCP_Client {
    public static void main(String[] args) throws IOException {
        System.out.println("1.传入IP地址与端口号，建立Socket对象");
        System.out.println("在创建对象的时候会连接服务器，如果连接不上会报错");
        Socket socket = new Socket("127.0.0.1",10000);

        System.out.println("2.通过套接字对象获取字节输出流，向客户端输入数据");
        OutputStream os = socket.getOutputStream();
        os.write("Hello, TCP!".getBytes());

        System.out.println("3.关闭socket也可以关闭输出流");
        socket.close();

        String abc = "sddddddd";
        abc.matches("thunderx?:\\/\\/[a-zA-Z\\d]+=");
    }
}
