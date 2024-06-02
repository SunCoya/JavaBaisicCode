package Day34_InternetPractice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo342_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();
        System.out.println(new String(socket.getInputStream().readAllBytes()));
        socket.shutdownInput();
        socket.getOutputStream().write("服务端向客户端返回数据!".getBytes());
        socket.close();
        ss.close();
    }
}
