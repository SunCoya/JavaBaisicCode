package Day36;

/*
元注解：注解的注解
@Target：约束注解使用的地方
@Retention：申明注解的生命周期
*/
public @interface MyAnno {
    //可以不写默认值
    public String name()default "???";
    public int age();
}
