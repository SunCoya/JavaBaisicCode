package Day34_InternetPractice.homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
1.多次使用对同一个套接字使用socket.getInputStream()获得的是同一个对象吗？
这里需要注意这样获得的对象不是同一个对象，所以我这里就只用了一个输入流，一个输出流
2.如何一起表示多行字符串？
使用文本块"""文本内容"""即可换行（JDK15引入）不用一个个加换行辣！！！
*/
public class MyRunnableForClient {
    //提前定义需要用到的变量
    Socket socket;
    BufferedReader br;
    BufferedWriter bw;
    Scanner scanner;

    public MyRunnableForClient(Socket socket) {
        //在构造方法里面初始化上面的变量
        this.socket = socket;
        scanner = new Scanner(System.in);
        try {
            //多次定义br会有不同的对象地址
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        System.out.println("服务器启动成功");
        while (true) {
            //文本块
            System.out.println("""
                    ======欢迎来到聊天室======
                    1.登录
                    2.注册
                    请输入您的选择""");
            //在这里输入不同的数字进行选择，返回输入的数字
            if ("2".equals(chooseNum())) {
                //选择2则代表注册
                sendRegInfo();
                //返回的信息状态代表不同的注册情况
                if ("1".equals(br.readLine())) System.out.println("注册成功");
                else System.out.println("注册失败！用户名重复");
                continue;
            }
            //用户选择了登录
            login();
            //返回登录状态，做出不同回应
            String num = br.readLine();
            if ("2".equals(num)) System.out.println("密码有误");
            else if ("3".equals(num)) System.out.println("用户名不存在");
            else break;
        }
        System.out.println("登录成功");
        //在发送信息前提前开启一个接收信息的线程
        new Thread(() -> {//基本上一模一样，除了输入输出流对象
            try {
                while (true) System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        while (true) send(scanner.nextLine());
    }

    //循环输入，直到正确为止，发送选择并且返回输入的字符串
    private String chooseNum() throws IOException {
        String str;
        while (true) {
            str = scanner.nextLine();
            if ("1".equals(str) || "2".equals(str)) break;
            System.out.println("请输入正确的数字！");
        }
        send(str);
        return str;
    }

    //循环发送注册信息：直到正确为止
    private void sendRegInfo() throws IOException {
        while (true) {
            System.out.println("请输入用户名");
            String username = scanner.nextLine();
            System.out.println("请选择密码");
            String password = scanner.nextLine();
            if (username.matches("[a-zA-Z]{6,18}") && password.matches("[a-zA-Z][0-9]{2,7}")) {
                send("username=" + username + "&" + "password=" + password);
                break;
            }
            System.out.println("输入格式错误！");
        }
    }

    //登录选择信息即可，不需要校验
    private void login() throws IOException {
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        send("username=" + username + "&" + "password=" + password);
    }

    private void send(String str) throws IOException {
        bw.write(str + "\n");
        bw.flush();
    }
}
