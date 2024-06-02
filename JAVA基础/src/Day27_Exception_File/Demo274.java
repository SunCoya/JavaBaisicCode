package Day27_Exception_File;
/*
throws与throw
1.throws在什么位置使用？作用是什么？
2.throws在可能有运行时异常的时候需要声明吗？
3.throw在什么位置使用？有什么作用？
*/
public class Demo274 {
    public static void main(String[] args) throws Exception{
        System.out.println("1.throws写在方法定义处表示声明一个异常，告诉调用者这个方法体里面可能会有那些异常");
        System.out.println("2.对于运行时期的异常可以省略不写，编译时产生的异常必须要声明");
        System.out.println("3.throw写在方法里面，抛出异常对象，交给调用者，并结束方法");
        throw new Exception();
    }
}
