package Day35_Reflect_DynamicAgent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/*
反射获取字节码文件中的成员方法：Method
1.使用getMethods方法与getDeclaredMethods方法有什么区别？
2.如何获取单个方法，传入的参数是？
3.如何返回方法抛出的异常？
4.如何使用method对某对象调用方法？传入的参数与返回的参数有什么特点？
*/
public class Demo354 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> studentClass = Class.forName("Day35_Reflect_DynamicAgent.Student");
        Method[] methods = studentClass.getMethods();
        System.out.println("1.使用getMethods方法同时也有继承于Object中的方法");
        for (Method method : methods)System.out.println(method);

        methods = studentClass.getDeclaredMethods();
        System.out.println("获取所有方法的时候不会包含继承下来的方法");
        for (Method method : methods)System.out.println(method);

        System.out.println("2.通过名字和形参获取一个方法，可以不加形参");
        Method method = studentClass.getMethod("setName",String.class);
        System.out.println(method);

        //修饰符，名字，参数
        System.out.println(method.getModifiers());
        System.out.println(method.getName());
        for (Parameter parameter : method.getParameters())System.out.println(parameter);

        System.out.println("3.使用getExceptionTypes返回方法抛出的异常数组");
        System.out.println(Arrays.toString(method.getExceptionTypes()));

        System.out.println("4.调用invoke（调用）方法，第一个参数传入对象，第二个参数没有就不写，方法没有返回也可以不写");
        Student student = new Student();
        method.invoke(student,"zhangsan");
        System.out.println(student);
    }
}
