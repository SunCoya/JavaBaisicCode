package Day35_Reflect_DynamicAgent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/*
从字节码文件里面获取数据对象的内容：本类测试获取构造方法对象Constructor
1.使用什么方法获取所有公共构造方法呢？
2.使用什么方法获取所有构造方法呢（包括私有）？
3.获取单个构造方法时传入的参数应该是？
4.如何获取构造方法内的权限修饰符？
5.如何读取方法中的参数？
6.如何使用私有构造方法创建变量？
*/
public class Demo352 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码文件对象
        Class<?> studentClass = Class.forName("Day35_Reflect_DynamicAgent.Student");

        System.out.println("1.使getConstructors获取构造方法，获取所有公共构造方法");
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) System.out.println(constructor);

        System.out.println("2.获取所有构造方法（Declared:公开声明的）");
        constructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) System.out.println(constructor);

        System.out.println("3.获取单个构造方法:指定构造方法可以传递参数:数据类型的字节码文件，基本数据类型也要传.class字节码文件");
        Constructor<?> constructor = studentClass.getConstructor();
        System.out.println(constructor);
        constructor = studentClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        constructor = studentClass.getDeclaredConstructor(int.class);
        System.out.println(constructor);

        //获取构造方法里面的内容
        System.out.println("4.使用getModifier方法读取权限修饰符：内容是2的整数倍（和底层运算效率有关，左右移就能改变）");
        //有什么用呢？写IDEA源码有用,提示能够直接看到能传上面参数
        System.out.println(constructor.getModifiers());

        System.out.println("5.使用getParameters方法读取有哪些参数");
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) System.out.println(parameter);

        System.out.println("6.使用构造方法创建对象：私有方法不能够创建对象，需要临时取消权限校验(暴力反射)");
        System.out.println("首先把构造方法调用setAccessible方法，传入true为参数");
        constructor.setAccessible(true);
        System.out.println("再使用构造方法的newInstance方法构造其对象");
        Student student = (Student) constructor.newInstance(23);
        System.out.println(student);
    }
}
