package Day35_Reflect_DynamicAgent;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/*
反射练习：保存信息
对于任意一个对象：把对象所有信息保存到文件当中，对于不同的对象都可以如此操作
*/
public class Demo355 {
    final static String FILE_STR = "D:\\IDEACode\\demo1\\JAVA基础\\src\\Day35_Reflect_DynamicAgent\\message.properties";
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Student student = new Student("zhansgan",123);
        Properties properties =new Properties();
        Class<?> studentClass = student.getClass();
        //获取字节码文件中的所有成员变量
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            //设置取消检验
            field.setAccessible(true);
            //获取变量名
            String name = field.getName();
            //获取对象中的该变量
            Object o = field.get(student);
            properties.put(name,o.toString());
        }
        properties.store(new FileWriter(FILE_STR),"addStudent");
    }
}
