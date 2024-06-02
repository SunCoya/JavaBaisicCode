package Day36;
/*
自定义注解：结合反射使用
能在变量上使用，也能在方法中使用
*/
public class Demo369MyAnno {
    //如果注解中只有一个属性，就可以只写值，如压制警告
    @MyAnno(name = "啊？",age=20)
    String aaa;
    String bbb;
    @MyAnno(name = "啊？",age=20)
    public void method(){
        System.out.println("方法一");
    }
    public void method2(){
        System.out.println("方法二");
    }
}
