package Day35_Reflect_DynamicAgent;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
利用配置文件（存储类名和方法名)，动态创建对象并调用方法
*/
public class Demo356 {
    final static String FILE_STR = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day35_Reflect_DynamicAgent\\prop.properties";
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        properties.load(new FileReader(FILE_STR));
        //获取字节码文件
        Class<?> aClass = Class.forName((properties.get("classname").toString()));
        //获取构造方法，创建对象
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        //获取方法名并调用
        Method method = aClass.getMethod(properties.get("method").toString());
        System.out.println(method.invoke(o));
    }
}
