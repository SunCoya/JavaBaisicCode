package Day33_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Demo333_Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] message = new byte[1024];
        DatagramPacket dp = new DatagramPacket(message,message.length);
        while (true){
            ds.receive(dp);
            String str = new String(dp.getData(),0,dp.getLength());
            InetAddress IP = dp.getAddress();
            int port = dp.getPort();
            System.out.println("IP为："+IP+"端口为："+port+"向10086端口发送了数据：");
            System.out.println(str);
            if ("886".equals(str))break;
        }
        ds.close();
    }
}
