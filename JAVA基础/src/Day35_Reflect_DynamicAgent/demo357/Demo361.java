package Day35_Reflect_DynamicAgent.demo357;
/*
动态代理：不修改原有的代码，又需要增加额外功能
为了程序的健壮性，不改变原有代码的功能，使用动态代理完成一些额外的事情
想要找某个核心人物做事情，需要先找它的代理人去说要做的事情，代理人里面也要有核心任务的方法

如何确定需要代理的方法呢？
为了确定需要代理的方法，需要让核心人物与代理人都实现某一个接口
*/
public class Demo361 {
    public static void main(String[] args) {
        //创建代理人
        Star proxy = ProxyUtil.createProxy(new BigStar("mona"));
        //使用代理人去调用方法
        System.out.println(proxy.sing("偶像宣言"));
        proxy.dance();
    }
}
