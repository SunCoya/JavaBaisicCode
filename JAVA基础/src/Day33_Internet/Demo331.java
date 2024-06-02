package Day33_Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
网络编程：在网络通信协议下，不同的计算机上运行的程序进行的数据传输
在Java中可以使用java.net包下的技术轻松开发出常见的网络应用程序

常见的软件架构：BS/CS
1.CS是什么架构？
ClientAndServer（客户端与服务器）本地客户端需要下载安装客户端程序，远程还有一个服务端程序
2.BS是什么架构？
BrowserAndServer（浏览器与服务器）只需要一个浏览器，用户通过不同的网址访问不同的服务器 ，
3.BS架构的优点与缺点？
不需要开发客户端，只需要页面与服务端，但是如果需要传递的数据过多过大就不适合使用网页了
很多时候都需要保存在本地-这就是客户端的形成，画面更加精美，

4.网络编程三要素有哪些？
如果要对对方传输数据
（1）.确定对方的网络地址：IP（设备在网络中的地址，是唯一标识）
（2）.确定对方的接收数据的软件：端口号（应用程序在设备中的唯一标识）
（3）.确定网络传输的规则：协议（数据在网络中的传输规则：如UDP，TCP，http，https，ftp）

5.IP的含义与常见的IP类型？
Internet Protocol,是互联网协议地址，也称IP地址：是分配给上网设备的数字标签
常见的IP分为IPv4与IPv6

6.什么是IPv4，地址长度为多少位？分为多少组？IP在转换的时候有没有负数？
Internet Protocol(协议) version4：互联网通信协议第四版（正式开始使用的就是第四版）
采用32位地址长度，分为4组，每一组1字节，每组最大就是255
用点分十进制表示就是：192.168.1.66，注意IP在转换的时候没有负数
所有IP加起来不到43亿个，在2019.11.26这些IP已经被全部分配完毕

7.什么是IPv6？地址长度为多少为？分为多少组？一般用什么表示？可以如何省略？
Internet Protocol version6：互联网通信协议第六版
采用128位地址长度，分为8组，每组两个字节（这数量有生之年不可能用的完了）
用冒分十六进制表示就是:2001:0DBB:0000:0023:0008:0800:200C:417A
一般省略每一组前面的0：2001:DBB:0:23:8:200C:417A
如果中间有很多0：就可以使用0位压缩表示法：FF01:0:0:0:0:0:0:1101->FF01::1101

8.IPv4的地址分类有哪两种？
一类是公网IP（万维网使用），一类是私有地址（局域网使用）
私有地址：
A类 10.0.0.0 --10.255.255.255
B类 172.16.0.0–172.31.255.255
C类 192.168.0.0–192.168.255.255
比如192.168开头的就是私有地址，范围就是192.168.0.0--192.168.255.255，专门为组织机构内部使用，以此节省IP

9.私有地址是公网地址吗？
比如在网吧中，不是每一台电脑都有一个公网的IP，一般是共享同一个公网IP，再由路由器给每台电脑分配局域网IP，由此节约IP

10.特殊IP：127.0.0.1：也可以是localhost是什么地址？
是送回地址，也是本地回环地址，成为本机IP，永远只会寻找当前所在的本机
如果电脑要发送消息：假如自己的Ip是192.168.1.100，如果发消息给自己这个IP，要先发送到路由器，再由路由器分配消息
不是每个路由器分配给你的IP是一样的，自己给自己发送数据就写127.0.0.1

11.常见的cmd命令有哪些？
ipConfig+ping(也能检查局域网是否畅通)

IP地址类：InetAddress
有两个子类：一个是IPv4，一个是IPv6，会自动判断是哪个版本的再去创建其子类对象
12.如何创建IP地址对象？
13.如何通过IP对象获取主机名与IP地址？
*/
public class Demo331 {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("12.使用InetAddress的静态方法去创建对象,可以传入IP，也能传入主机名");
        InetAddress IP1 = InetAddress.getByName("127.0.0.1");
        System.out.println(IP1);
        InetAddress IP2 = InetAddress.getByName("SUNCOYA-COMPUTER");
        System.out.println(IP2);

        System.out.println("13.通过getHostName方法获取主机名（如果局域网中没有这一台主机，那下面的输出就是以ip形式表示的）");
        System.out.println(IP2.getHostName());
        System.out.println("通过getHostAddress方法获取IP地址");
        System.out.println(IP2.getHostAddress());
    }
}
