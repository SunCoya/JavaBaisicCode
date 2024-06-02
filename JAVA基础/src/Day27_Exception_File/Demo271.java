package Day27_Exception_File;
import java.text.ParseException;
/*
程序出错：Error与Exception
Error对象：系统级别的错误，无需关注。
1.异常体系的最上层父类是？
异常体系的最上层父类是Exception

2.异常又分哪两种？
RuntimeException（运行异常：如数组越界） 与 其他异常（编译异常：如使用SimpleDateFormat的parse方法时）。
通过异常可以了解错误信息，作为一种特殊的返回值，通知调用着底层的执行情况

3.JVM发生运行异常的时候会做什么事情？
*/
public class Demo271 {
    public static void main(String[] args) throws ParseException {
        System.out.println("3.在Student类里面，年龄不对时抛出异常（throw new 异常名（描述）），停止运行");
        System.out.println("在Java运行过程中出错时，JMV默认的处理也是如此：把异常名称原因位置输出控制台，并且停止程序");
        new Student().setAge(17);
    }
}
