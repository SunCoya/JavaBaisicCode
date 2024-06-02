package Day34_InternetPractice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
接收多用户上传文件案例
1.如果想要接受多个用户的上传的文件，应该怎么办呢？
循环是不行的：只能一个个的处理用户，这里使用了多线程
2.应该在哪个地方截取多线程的代码？
循环accept接收部分：每接收一个用户，都开启一条线程
*/
public class Demo344_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        while (true) {
            Socket socket = ss.accept();
            new Demo344_Thread(socket).start();
        }
    }
}
