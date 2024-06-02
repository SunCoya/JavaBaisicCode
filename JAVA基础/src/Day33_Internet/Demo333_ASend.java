package Day33_Internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
/*
改聊天室
1.如何使一个类的运行变成多个不同的线程？
在右上角的类名点击Edit Configurations使一个类能重复运行多次
2.datagramPacket类中传入的数据如果是字符串转换的byte数组，传入长度的时候应该注意什么？
传入的应该是byte数组的长度
*/
public class Demo333_ASend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            byte[] bytes = input.getBytes();
            //这里的长度一开始传错了,注意不要传字符串的长度
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10086);
            ds.send(dp);
            //如果不关闭的话就变成了一个聊天室：多个人能够从这里面看到数据
            if ("886".equals(input)) break;
        }
        ds.close();
    }
}
