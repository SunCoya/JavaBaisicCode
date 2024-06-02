package Day34_InternetPractice.homework;

import java.io.*;
import java.net.Socket;
import java.util.*;
/*
properties也能够去接收txt文件
CSDN上面看到的：我这里就只创建一个输入输出流对象，这里可以了解一下
关于输入输出流的顺序与对象个数以后可以实验一下
服务器Socket和客户端Socket可以创建多个输入输出流对象，但是两端创建的个数必须保持对应
即通过客户端Socket创建多少个输入输出流对象，对应的服务器端的ServerSocket
通过accept()方法接收到Socket也必须创建多少个输入输出流对象。
*/
public class MyRunnableForServer implements Runnable {
    //定义输出流集合：这需要是同一个对象：每一个连接都需要这个集合，故为静态代码，其实定义在这里也只是为了少传一个参数，初始化
    static ArrayList<BufferedWriter> arrayList= new ArrayList<>();

    //四个常用的变量:套接字连接，输入，输出，键盘输入
    Socket socket;
    BufferedWriter bw;
    BufferedReader br;
    Scanner scanner;
    //用户信息，登陆的用户名
    Properties properties;
    String name;

    public MyRunnableForServer(Socket socket) {
        //每创建一个对象都要初始化上面的七个变量
        this.socket = socket;
        scanner = new Scanner(System.in);
        properties = new Properties();
        try {
            properties.load(new FileInputStream(Server.STR_PATH));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            //接收数据，这一块用户用户的登录与注册
            while (true) {
                //用户选择注册
                if ("2".equals(br.readLine())) {
                    receiveUserReg();
                    continue;
                }
                //用户选择登录
                if (receiveUserInfo()) break;
            }
            //开始聊天了：接收数据，然后转发给所有人
            //先把能聊天的加入集合
            arrayList.add(bw);
            while (true) {
                //接收客户端的数据,接收到了再发
                String str = br.readLine();
                //接收到信息直接遍历字符输出流:用输出流去发消息
                for (BufferedWriter writer : arrayList) {
                    writer.write(name + "说：" + str + "\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收用户数据，返回注册数据：成功或者失败：默认发过来的数据是符合规范的
    private void receiveUserReg() throws IOException {
        String userInfo = br.readLine();
        String username = userInfo.split("&")[0].replace("username=", "");
        String password = userInfo.split("&")[1].replace("password=", "");
        //2代表用户名已存在，注册失败
        if (properties.containsKey(username)) {
            send("2");
            return;
        }
        //1代表可以注册，更新文件中的数据，也把数据放到当前所有用户的集合当中
        properties.put(username, password);
        properties.store(new FileWriter(Server.STR_PATH), "");
        send("1");
    }

    //用户登录并判断，返回true环开始聊天打破循，返回false继续循环
    //发给客户端状态码
    private boolean receiveUserInfo() throws IOException {
        String userInfo = br.readLine();
        String username = userInfo.split("&")[0].replace("username=", "");
        String password = userInfo.split("&")[1].replace("password=", "");
        //在这里可以传入字符串进行判断：一开始写错了，写成了contains，注意方法名
        if (properties.containsKey(username)) {
            if (properties.get(username).equals(password)) {
                //包含用户名且密码正确返回状态码1，返回ture
                send("1");
                name = username;
                return true;
                //其他根据情况返回状态码，返回false
            } else send("2");
        } else send("3");
        return false;
    }
    //这里由于是缓冲流：需要刷新，然后接收方才能有输出
    private void send(String str) throws IOException {
        bw.write(str + "\n");
        bw.flush();
    }
}
