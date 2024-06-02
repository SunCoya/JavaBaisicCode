package Day34_InternetPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Demo344_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10086);

        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("C:\\Users\\33428\\Videos\\haniwa\\いつだって戦ってる.mp4");
        int len;
        byte[] bytes  = new byte[256];
        while ((len = fis.read(bytes))!=-1)os.write(bytes,0,len);
        fis.close();

        socket.shutdownOutput();
        System.out.println(new String(socket.getInputStream().readAllBytes()));
        socket.close();
    }
}
