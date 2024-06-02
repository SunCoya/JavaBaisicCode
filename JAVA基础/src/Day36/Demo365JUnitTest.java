package Day36;

import org.junit.Test;

/*
单元测试：针对Java中的方法的测试
编写测试方法：public void method()，一定要是非静态方法，在测试方法上使用@Test注解
左边的External Libraries中出现JUnit4
点击类名左边的绿色箭头可测试多个方法
*/
public class Demo365JUnitTest {
    @Test
    public void method1(){
        System.out.println("测试方法一");
    }
    @Test
    public void method2(){
        System.out.println("测试方法二");
    }
    @Test
    public void method3(){
        System.out.println("测试方法三");
    }
}
