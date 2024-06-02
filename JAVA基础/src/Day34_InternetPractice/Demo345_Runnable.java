package Day34_InternetPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.UUID;

class Demo345_Runnable implements Runnable {
    Socket socket;
    public Demo345_Runnable(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            String fileName = UUID.randomUUID().toString().replace("-","");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\33428\\Desktop\\" +fileName+".mp4");
            byte[] bytes = new byte[256];
            int len;
            while ((len = is.read(bytes)) != -1) fos.write(bytes, 0, len);
            fos.close();
            socket.shutdownInput();
            socket.getOutputStream().write("服务端已经接收到所有数据!".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
