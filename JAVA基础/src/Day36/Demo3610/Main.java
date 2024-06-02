package Day36.Demo3610;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
用注解模拟JUnit
*/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("Day36.Demo3610.Main");
        //补个对象
        Main main = new Main();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(MyTest.class)){
                method.invoke(main);
            }
        }
    }

    @MyTest
    public void method1(){
        System.out.println("方法一");
    }
    @MyTest
    public void method2(){
        System.out.println("方法二");
    }
    public void method3(){
        System.out.println("方法三");
    }
}
