package Day34_InternetPractice.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/*
控制台上面的聊天室
没必要的数据就无需去放在服务器里面：放在客户端即可！
服务器就做一个最基本的接收-处理-发送
*/
public class Client {
    public static void main(String[] args) throws IOException {
        //建立连接，开始运行，其实可以写到一个类里面
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10000);
        MyRunnableForClient runnable = new MyRunnableForClient(socket);
        runnable.run();
    }
}
