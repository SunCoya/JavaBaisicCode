package Day34_InternetPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;



//频繁的创建和销毁线程浪费系统资源：线程池优化
public class Demo345_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10086);

        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("C:\\Users\\33428\\Videos\\haniwa\\いつだって戦ってる.mp4");
        int len;
        byte[] bytes  = new byte[128];
        while ((len = fis.read(bytes))!=-1)os.write(bytes,0,len);
        fis.close();

        socket.shutdownOutput();
        System.out.println(new String(socket.getInputStream().readAllBytes()));
        socket.close();
    }
}
