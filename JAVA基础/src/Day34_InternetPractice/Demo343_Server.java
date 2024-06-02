package Day34_InternetPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
/*
类UUID：可以生成随机唯一的字符串，字符串内容唯一
如何使用UUID获取随机字符串？
*/
public class Demo343_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        System.out.println("使用UUID的静态方法randomUUID，变成字符串再替换掉-即可生成随机字符串，由字母数字组成");
        String fileName = UUID.randomUUID().toString().replace("-","");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\33428\\Desktop\\" +fileName+".mp4");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes))!=-1)fos.write(bytes,0,len);
        fos.close();

        socket.shutdownInput();
        socket.getOutputStream().write("服务端已经接收到所有数据!".getBytes());
        socket.close();
        ss.close();
    }
}
