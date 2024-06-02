package Day27_Exception_File;
/*
try-catch语句
1.区别于区别于JVM默认处理方式，使用try-catch处理可以让代码继续往下走，如果代码遇到错误，错误代码下面的代码还会执行吗？
2.有多种异常需要处理应该如何使用try-catch语句呢？
3.连续catch时，对异常的顺序有什么要求？
*/

public class Demo272 {
    public static void main(String[] args) {
        try {
            System.out.println("1.逮到错误就直接到catch里面处理，try中错误代码后面的代码不会执行");
            new Student().setAge(17);

            System.out.println(2/0);
            int[] a  = new int[1];
            System.out.println(a[10]);
            String str = null;
            str.equals("");
        } catch (ArithmeticException|NullPointerException e){
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (RuntimeException e){
            System.out.println("2.有多种可能出现的异常或者异常不确定可以连续catch");
            System.out.println("3.catch时，父类只能写在最后面");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
