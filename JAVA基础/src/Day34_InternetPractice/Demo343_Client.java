package Day34_InternetPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


//上传文件案例
public class Demo343_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10086);

        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("C:\\Users\\33428\\Videos\\haniwa\\いつだって戦ってる.mp4");
        int len;
        byte[] bytes  = new byte[1024];
        //如果使用的是字节缓冲输出流需要使用flush方法刷新缓冲区，不然shutdown之后有可能会造成数据没有写完
        while ((len = fis.read(bytes))!=-1)os.write(bytes,0,len);
        fis.close();

        socket.shutdownOutput();
        System.out.println(new String(socket.getInputStream().readAllBytes()));
        socket.close();
    }
}
