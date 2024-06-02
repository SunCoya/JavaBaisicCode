package Day34_InternetPractice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Demo345_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,8,10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(9),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket socket = ss.accept();
            pool.submit(new Demo345_Runnable(socket));
        }
    }
}
