package Day33_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
单播：只给一台设备发送数据
组播：给一组设备发送数据（224.0.0.0—239.255.255.255）其中（224.0.0.0-224.0.0.255)256个为预留的组播地址）
广播：给局域网中所有的电脑发送数据255.255.255.255（四字节都是最大），广播就不试了，把单播的地址改为255.255.255.255即可
*/
public class Demo334_MultiCast_ASend {
    public static void main(String[] args) throws IOException {
        System.out.println("1.创建组播对象MulticastSocket（组播套接字）");
        MulticastSocket ms = new MulticastSocket();

        System.out.println("2.打包数据也是一样的流程");
        String s = "Hello, MulticastSocket";
        byte[] bytes = s.getBytes();
        System.out.println("IP指定为组播地址（不知道为什么224.0.0.1不行）");
        InetAddress IP = InetAddress.getByName("224.0.0.2");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,IP,port);

        System.out.println("3.使用组播套接字对象发送数据");
        ms.send(dp);
        ms.close();
    }
}
