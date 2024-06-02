package Day34_InternetPractice.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //定义路径，定义在这里好修改一点
    static String STR_PATH = "JAVA基础\\src\\Day34_InternetPractice\\homework\\userInfo.properties";
    public static void main(String[] args) throws IOException {
        //定义服务套接字，创建线程池，接收连接并提交任务
        ServerSocket serverSocket = new ServerSocket(10000);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.submit(new MyRunnableForServer(socket));
        }
    }
}
