package Day33_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
1.利用UDP接受数据数据：以快递为例
1.找快递公司2.接收打包3.在箱子里面找礼物（解析数据）4.签收走人（释放资源）

2.接收端与发送端的运行顺序有要求吗？
先运行接收端，再运行发送端，下面的控制台能够切换
*/
public class Demo332_Receive {
    public static void main(String[] args) throws IOException {
        System.out.println("(1)创建接收端的DatagramSocket对象，需要指定发送端的端口");
        DatagramSocket ds = new DatagramSocket(10086);

        System.out.println("(2)新建datagramPacket对象，接收对象需要的数组与长度也需要传递, 不需要传递端口");
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        System.out.println("使用ds的receive方法接收对象，方法是阻塞的：程序执行到这里会死等数据的到来");
        ds.receive(dp);

        System.out.println("(3)使用dp的get数据方法解析数据包");
        byte[] data = dp.getData();
        int length = dp.getLength();
        InetAddress IP = dp.getAddress();
        int port = dp.getPort();
        //变成字符串注意一下长度
        System.out.println(new String(data,0,length)+"\n数据长度："+length+"\n数据发送地址："+IP+"\n端口："+port);

        System.out.println("(4)关闭接收端");
        ds.close();
    }
}
