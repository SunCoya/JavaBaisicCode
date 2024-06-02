package Day33_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Demo334_MultiCast_Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("1.创建组播套接字，并设置接收端口");
        MulticastSocket ms = new MulticastSocket(10000);

        System.out.println("2.将本机添加到224.0.0.2当中，往后就是接收，解析，关闭");
        ms.joinGroup(InetAddress.getByName("224.0.0.2"));

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ms.receive(dp);

        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();
        int port = dp.getPort();
        byte[] data = dp.getData();
        System.out.println("ip为"+ip+",主机名为"+name+"的及设备的端口号"+port+"发送了数据");
        System.out.println(new String(data,0,data.length));
        ms.close();
    }
}
