package Day27_Exception_File;
/*
异常中常见的方法(定义在最顶级的Throwable类内)
1.异常对象输出信息（默认报错方式）？
2.如何获取异常的简短信息？
3.如何输出错误信息（红色字体）？
*/
public class Demo273 {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        }catch (ArithmeticException e){
            System.out.println("1.使用printStackTrace方法是控制台输出错误信息，能跟踪报错位置");
            e.printStackTrace();
            System.out.println("2.返回详细信息与返回简短信息");
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        System.err.println("3.打印错误信息（红色字与黑色字所处顺序会变化，与多线程有关）");
    }
}
