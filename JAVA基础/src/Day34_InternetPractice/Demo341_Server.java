package Day34_InternetPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/*
1.如何启动服务器之后通过浏览器访问？
在这里只启动这服务器，然后浏览器输入127.0.0.1:10086就能访问
2.在此处的输入流接收到一条数据之后没有发送消息不会断开连接，为什么？
*/
public class Demo341_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        System.out.println("2.在服务端的Reader中，读不到数据理应停止，但是这里却不是————只要有连接就能一直读");
        System.out.println("服务端获取到的字节输入流可能会出现没有数据的情况。此时调用的read()方法会出现阻塞，也就是会一直等待直到数据可读。");
        while ((str = reader.readLine()) != null)System.out.println(str);
        socket.close();
        ss.close();
    }
}
