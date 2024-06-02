package Day36;
/*
注解主要是给编译器看的，用来检测
@Deprecated:表示方法已经过时:也会给你提示替代方案
@SuppressWarnings("all")：压制（去除）警告
*/
@SuppressWarnings("all")
public class Demo368Annotation {
    public static void main(String[] args) {
        int a;
    }
    @Deprecated
    public static void method(){
        System.out.println("haihai");
    }
}
