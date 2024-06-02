package Day35_Reflect_DynamicAgent;

import java.lang.reflect.Field;

/*
反射获取字节码文件中的成员变量Field
1.获取单个变量需要传入的参数？
2.如何获取变量名？
3.如何获取变量类型？
4.如何获取对象中的变量的值？
5.如何修改对象中变量的值？
*/
public class Demo353 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取Field也是一样的方法
        Class<?> studentClass = Class.forName("Day35_Reflect_DynamicAgent.Student");
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields) System.out.println(field);
        System.out.println("1.获取单个成员变量：传入变量名字符串");
        Field field = studentClass.getDeclaredField("age");
        //获取成员变量信息
        System.out.println(field.getModifiers());
        System.out.println("2.使用getName方法获取变量名");
        System.out.println(field.getName());
        System.out.println("3.使用getType方法获取变量类型");
        Class<?> type = field.getType();
        System.out.println(type);

        System.out.println("4.使用get方法传入某对象，获取这个成员变量在该对象中的值，同样也需要取消权限校验");
        field.setAccessible(true);
        Student student = new Student("zhangsan", 123);
        Object age = field.get(student);
        System.out.println(age);

        System.out.println("5.使用set方法，传入某对象与修改的值，对该对象中的成员变量修改");
        field.set(student,1234);
        System.out.println(student);
    }
}
