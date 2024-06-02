package Day35_Reflect_DynamicAgent.demo357;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//创建一个代理
public class ProxyUtil {

    public static Star createProxy(BigStar bigStar) {
        System.out.println("""
                1.创建静态方法返回一个代理人（类型为BigStar实现的结构）
                方法作用：给明星对象创建一个代理
                形参：被代理的明星对象
                返回一个接口，也是返回代理对象
                """);
        System.out.println("2.使用Proxy的newProxyInstance方法创建代理人对象，传入三个参数");
        System.out.println("""
                参数一：指定类加载器加载生成的代理类：找到谁加载了这个类
                参数二：指定接口数组，用于指定代理能代理哪些方法
                参数三：指定代理要干什么事情，在这个参数需要的对象需要实现的方法参数有三个
                
                参数一：代理的对象,暂时用不到
                参数二：要运行的方法
                参数三：调用方法的时候需要传递的实参
                """);
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        参数一：代理的对象,暂时用不到
                        参数二：要运行的方法
                        参数三：调用方法的时候需要传递的实参
                        */
                        if ("sing".equals(method.getName()))
                            System.out.println("代理人：准备话筒");
                        else if ("dance".equals(method.getName()))
                            System.out.println("代理人：准备场地");
                        //返回运行结果
                        return method.invoke(bigStar, args);
                    }
                }
        );
        return star;
    }
}
