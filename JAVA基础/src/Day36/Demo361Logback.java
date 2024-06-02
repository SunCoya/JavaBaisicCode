package Day36;
//注意别引错包了
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
使用Logback写日志
把输出语句保存到文件当中
接口规范：Commons Logging(JCL)与Simple Logging Facade for java(slf4j)
日志实现框架：JUL(Java自带)、log4j、Logback（现在学习的，基于slf4j）
在使用Logger前应该做的准备工作有哪些？
1.需要导入的jar包：slf4j(规范)logback-core(核心)logback-classic(实现了完整的slf4j)logback-access(与汤猫服务器继承，提供了日志访问功能)
2.将配置文件logback.xml拷贝到src目录下

在测试类中如何使用logback产生日志文件？
1.通过LoggerFactory类的静态方法getLogger，传入本类对象创建Logger对象
2.通过Logger的info（或者其他方法记录信息）写入日志信息
*/
public class Demo361Logback {
    final static Logger LOGGER = LoggerFactory.getLogger("Demo361Logback.class");
    public static void main(String[] args) {
        LOGGER.info("SunCoya学习日志");
    }
}
