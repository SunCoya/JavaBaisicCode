package Day33_Internet;

import java.io.IOException;
import java.net.*;

/*
1.端口号是什么？由多少字节表示？端口号的范围为？什么范围的端口号被占用？
应用程序在设备中的唯一标识，由两个字节表示的整数，范围为0-65535
0-1023端口用于知名的网络服务或者是应用，一个端口号只能被一个应用使用。

协议：连接和通信的规则被称为网络通信协议
下面两个是传输层协议：
2.什么是UDP？有什么特点？
（User Datagram Protocol）
是面向无连接通信协议（数据直接发送，不检查两台电脑是否可以连通，爱要不要），
传输速度快，有大小限制，一次最多发送64K，数据不安全，容易丢失数据
用于丢一点数据不太影响功能的应用：语音通话网络会议可以使用
3.什么是TCP？有什么特点？
（Transmission Control Protocol（传输控制协议））
是面向连接的通信协议，速度慢，没有大小限制，数据安全
比如发送邮件

4.利用UDP发送数据的具体步骤？
以快递为例
1.找快递公司2.打包礼物3.快递公司发送包裹4.付钱走人
*/
public class Demo332_ASend {
    public static void main(String[] args) throws IOException {
        System.out.println("(1)使用DatagramSocket（数据包套接字）创建对象的时候可以指定端口：如果不指定，随机使用一个端口发");
        DatagramSocket ds = new DatagramSocket();

        System.out.println("(2)使用DatagramPacket包裹信息：数据，长度，IP，端口");
        byte[] bytes = "你好UDP协议！".getBytes();
        InetAddress IP = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,IP,port);

        System.out.println("(3)使用datagramSocket对象的send方法发送datagramPacket数据");
        ds.send(dp);
        System.out.println("(4)释放datagramSocket资源");
        ds.close();
    }
}
