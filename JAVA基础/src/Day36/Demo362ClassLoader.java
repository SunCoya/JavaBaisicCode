package Day36;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
类加载器：把字节码class文件搬运到虚拟机里面

类加载时机-用到才加载
1.创建对象 2.调用静态方法 3.访问静态变量 4.使用反射创建class对象 5.初始化子类 6.java.exe

类加载过程
加载：
    通过全限定名获取定义此类的二进制流
    把静态存储结构转化为运行时数据结构
    加载完毕则创建一个class对象
连接：
    验证：检查信息有没有安全隐患
    准备：为静态变量初始化值—默认
    解析：加载把引用型变量需要用到的类，把符号引用变为直接引用
初始化：
    初始化静态变量：变为被复制的值

加载器分类
所有加载请求都会被送到最顶层的启动类加载器，然后往下送，看那个加载器能加载
启动类加载器：虚拟机内置类加载器
平台类加载器：加载JDK特殊模块
系统类加载器：加载用户类路径上所指定的类库
自定义加载器
*/
public class Demo362ClassLoader {
    final static String FILE_STR = "Day35_Reflect_DynamicAgent\\message.properties";
    public static void main(String[] args) throws IOException {
        //获得系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader platformClassLoader = systemClassLoader.getParent();
        ClassLoader bootStrapClassLoader = platformClassLoader.getParent();
        System.out.println(systemClassLoader);
        System.out.println(platformClassLoader);
        System.out.println(bootStrapClassLoader);

        //加载某一个资源文件:只能设置本模块中的路径
        InputStream stream = systemClassLoader.getResourceAsStream(FILE_STR);
        Properties properties = new Properties();
        properties.load(stream);
        System.out.println(properties);
        stream.close();
    }
}
